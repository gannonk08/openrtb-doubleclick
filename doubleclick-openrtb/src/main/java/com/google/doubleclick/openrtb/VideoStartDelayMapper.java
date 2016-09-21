/*
 * Copyright 2014 Google Inc. All Rights Reserved.
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

package com.google.doubleclick.openrtb;

import com.google.openrtb.OpenRtb.StartDelay;

/**
 * Maps between AdX's {@code videoad_start_delay} and OpenRTB's {@code startdelay}.
 */
public class VideoStartDelayMapper {
  public static int toOpenRtb(int dc) {
    switch (dc) {
      case -1:
        return StartDelay.GENERIC_POST_ROLL_VALUE;
      case 0:
        return StartDelay.PRE_ROLL_VALUE;
      default:
        return dc / 1000;
    }
  }

  public static int toDoubleClick(int openrtb) {
    switch (openrtb) {
      case StartDelay.GENERIC_MID_ROLL_VALUE:
        return 1;
      case StartDelay.GENERIC_POST_ROLL_VALUE:
        return -1;
      case StartDelay.PRE_ROLL_VALUE:
        return 0;
      default:
        return openrtb * 1000;
    }
  }
}
