/*
 * Copyright (c) 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.client.auth.oauth;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Hide;

/**
 * OAuth 1.0a URI entity to request to exchange the temporary credentials token
 * (or "request token") for a long-lived credentials token (or "access token")
 * from an authorization server.
 * <p>
 * Use {@link #execute()} to execute the request. The long-lived access token
 * acquired with this request is found in {@link OAuthCredentialsResponse#token}
 * . This token must be stored. It may then be used to authorize HTTP requests
 * to protected resources by setting the {@link OAuthAuthorizer#token}, and
 * using the {@link OAuthAuthorizer} for {@link HttpHeaders#authorizer}.
 * 
 * @since 2.2
 */
public class OAuthGetAccessToken extends AbstractOAuthGetToken {

  /**
   * Required temporary token. It is retrieved from the
   * {@link OAuthCredentialsResponse#token} returned from
   * {@link OAuthGetTemporaryToken#execute()}.
   */
  @Hide
  public volatile String temporaryToken;

  /**
   * Required verifier code received from the server when the temporary token
   * was authorized. It is retrieved from {@link OAuthCallbackUri#verifier}.
   */
  @Hide
  public volatile String verifier;

  /**
   * @param authorizationServerUri encoded authorization server URI
   */
  public OAuthGetAccessToken(String authorizationServerUri) {
    super(authorizationServerUri);
  }

  @Override
  public OAuthAuthorizer createAuthorizer() {
    OAuthAuthorizer result = super.createAuthorizer();
    result.token = temporaryToken;
    result.verifier = verifier;
    return result;
  }
}