/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doubleclick.openrtb.json;

import static com.google.openrtb.json.OpenRtbJsonUtils.getCurrentName;

import com.fasterxml.jackson.core.JsonParser;
import com.google.doubleclick.AdxExt;
import com.google.doubleclick.AdxExt.SiteExt;
import com.google.openrtb.OpenRtb.BidRequest.Site;
import com.google.openrtb.json.OpenRtbJsonExtComplexReader;
import java.io.IOException;

/**
 * Reader for {@link SiteExt}.
 */
class SiteExtReader extends OpenRtbJsonExtComplexReader<Site.Builder, SiteExt.Builder> {

  public SiteExtReader() {
    super(AdxExt.site, false, "amp");
  }

  @Override protected void read(SiteExt.Builder ext, JsonParser par) throws IOException {
    switch (getCurrentName(par)) {
      case "amp": {
          SiteExt.AmpPage value = SiteExt.AmpPage.forNumber(par.nextIntValue(0));
          if (checkEnum(value)) {
            ext.setAmp(value);
          }
        }
        break;
    }
  }
}
