/*
 *    Copyright (C) 2015 - 2016 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.vrem.wifianalyzer.navigation;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.vrem.wifianalyzer.R;
import com.vrem.wifianalyzer.settings.SettingActivity;
import com.vrem.wifianalyzer.vendor.VendorFragment;
import com.vrem.wifianalyzer.wifi.AccessPointsFragment;
import com.vrem.wifianalyzer.wifi.ChannelRatingFragment;

public enum NavigationMenu {
    ACCESS_POINTS(R.mipmap.ic_launcher, R.string.action_access_points, true, new AccessPointsFragment()),
    CHANNEL_RATING(R.drawable.ic_wifi_tethering_grey_500_48dp, R.string.action_channel_rating, true, new ChannelRatingFragment()),
    VENDOR_LIST(R.drawable.ic_list_grey_500_48dp, R.string.action_vendors, false, new VendorFragment()),
    SETTINGS(R.drawable.ic_settings_grey_500_48dp, R.string.action_settings, SettingActivity.class);

    private final int icon;
    private final int title;
    private final boolean subTitle;
    private final Fragment fragment;
    private final Class<? extends Activity> activity;

    NavigationMenu(int icon, int title, boolean subTitle, @NonNull Fragment fragment) {
        this.icon = icon;
        this.title = title;
        this.subTitle = subTitle;
        this.fragment = fragment;
        this.activity = null;
    }

    NavigationMenu(int icon, int title, @NonNull Class<? extends Activity> activity) {
        this.icon = icon;
        this.title = title;
        this.subTitle = false;
        this.fragment = null;
        this.activity = activity;
    }

    static NavigationMenu find(int index) {
        try {
            return values()[index];
        } catch (Exception e) {
            return NavigationMenu.ACCESS_POINTS;
        }
    }

    public Fragment getFragment() {
        return fragment;
    }

    public Class<? extends Activity> getActivity() {
        return activity;
    }

    public int getTitle() {
        return title;
    }

    public boolean isSubTitle() {
        return subTitle;
    }

    int getIcon() {
        return icon;
    }
}