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

package com.google.api.client.http;

import java.io.IOException;
import java.io.InputStream;

public interface LowLevelHttpResponse {

  InputStream getContent() throws IOException;

  String getContentEncoding();

  long getContentLength();

  String getContentType();

  /** Response status line or {@code null} for none. */
  String getStatusLine();

  int getStatusCode();

  String getReasonPhrase();

  int getHeaderCount();

  String getHeaderName(int index);

  String getHeaderValue(int index);
}
