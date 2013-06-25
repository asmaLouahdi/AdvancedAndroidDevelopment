package com.siteduzero.android.samples;

import java.util.ArrayList;
import java.util.List;

import com.siteduzero.android.R;
import com.siteduzero.android.actionbar.ActionBarContextualActivity;
import com.siteduzero.android.actionbar.ActionBarContextualListActivity;
import com.siteduzero.android.actionbar.ActionBarSimpleActivity;
import com.siteduzero.android.dialog.DialogActivity;
import com.siteduzero.android.dynamicui.DynamicUIActivity;
import com.siteduzero.android.fragments.dynamic.DynamicActivity;
import com.siteduzero.android.fragments.fixe.FixeActivity;
import com.siteduzero.android.lists.custom.CustomListActivity;
import com.siteduzero.android.lists.dynamic.DynamicListActivity;
import com.siteduzero.android.lists.simple.SimpleListActivity;
import com.siteduzero.android.multiscreens.MultiScreensActivity;
import com.siteduzero.android.navigation.drawer.DrawerLayoutActivity;
import com.siteduzero.android.navigation.slidingpane.SlidingPaneLayoutActivity;
import com.siteduzero.android.navigation.viewpager.ViewPagerActivity;
import com.siteduzero.android.nfc.NFCActivity;
import com.siteduzero.android.nfc.NFCBeamActivity;
import com.siteduzero.android.nfc.NFCEmulatorActivity;
import com.siteduzero.android.notifications.NotificationsActivity;
import com.siteduzero.android.requests.products.PHPRequestActivity;
import com.siteduzero.android.requests.security.AuthenticationActivity;
import com.siteduzero.android.services.auth.ServiceAuthorizationListActivity;
import com.siteduzero.android.services.plus.SignInActivity;
import com.siteduzero.android.settings.UsingSettingsActivity;

public class SamplesController {
	private static final SamplesController INSTANCE = new SamplesController();
	private List<SamplesItem> mItems = new ArrayList<SamplesItem>();

	public SamplesController() {
		mItems.add(new SamplesItem(R.string.title_fragment_fixe,
				R.string.part_1, R.string.chapter_1, FixeActivity.class));
		mItems.add(new SamplesItem(R.string.title_fragment_dynamic,
				R.string.part_1, R.string.chapter_1, DynamicActivity.class));
		mItems.add(new SamplesItem(R.string.title_listfragment_simple,
				R.string.part_1, R.string.chapter_2, SimpleListActivity.class));
		mItems.add(new SamplesItem(R.string.title_listfragment_custom,
				R.string.part_1, R.string.chapter_2, CustomListActivity.class));
		mItems.add(new SamplesItem(R.string.title_listfragment_dynamic,
				R.string.part_1, R.string.chapter_2, DynamicListActivity.class));
		mItems.add(new SamplesItem(R.string.title_dynamic_ui, R.string.part_1,
				R.string.chapter_3, DynamicUIActivity.class));
		mItems.add(new SamplesItem(R.string.title_fragment_settings,
				R.string.part_1, R.string.chapter_4,
				UsingSettingsActivity.class));
		mItems.add(new SamplesItem(R.string.title_fragment_dialog,
				R.string.part_1, R.string.chapter_5, DialogActivity.class));
		mItems.add(new SamplesItem(R.string.title_actionbar_simple,
				R.string.part_2, R.string.chapter_1,
				ActionBarSimpleActivity.class));
		mItems.add(new SamplesItem(R.string.title_actionbar_contextual,
				R.string.part_2, R.string.chapter_1,
				ActionBarContextualActivity.class));
		mItems.add(new SamplesItem(R.string.title_actionbar_contextual_list,
				R.string.part_2, R.string.chapter_1,
				ActionBarContextualListActivity.class));
		mItems.add(new SamplesItem(R.string.title_drawer, R.string.part_2,
				R.string.chapter_2, DrawerLayoutActivity.class));
		mItems.add(new SamplesItem(R.string.title_sliding_pane,
				R.string.part_2, R.string.chapter_2,
				SlidingPaneLayoutActivity.class));
		mItems.add(new SamplesItem(R.string.title_viewpager, R.string.part_2,
				R.string.chapter_2, ViewPagerActivity.class));
		mItems.add(new SamplesItem(R.string.title_multiple_screens,
				R.string.part_2, R.string.chapter_3, MultiScreensActivity.class));
		mItems.add(new SamplesItem(R.string.title_notifications,
				R.string.part_2, R.string.chapter_4,
				NotificationsActivity.class));
		mItems.add(new SamplesItem(R.string.title_nfc_emulator,
				R.string.part_2, R.string.chapter_5, NFCEmulatorActivity.class));
		mItems.add(new SamplesItem(R.string.title_nfc_normal, R.string.part_2,
				R.string.chapter_5, NFCActivity.class));
		mItems.add(new SamplesItem(R.string.title_nfc_beam, R.string.part_2,
				R.string.chapter_5, NFCBeamActivity.class));
		mItems.add(new SamplesItem(R.string.title_remote_data, R.string.part_3,
				R.string.chapter_3, PHPRequestActivity.class));
		mItems.add(new SamplesItem(R.string.title_request_auth,
				R.string.part_3, R.string.no_chapter,
				AuthenticationActivity.class));
		mItems.add(new SamplesItem(R.string.title_services_authorization,
				R.string.part_4, R.string.chapter_2,
				ServiceAuthorizationListActivity.class));
		mItems.add(new SamplesItem(R.string.title_services_sign_in,
				R.string.part_4, R.string.chapter_3, SignInActivity.class));
	}

	public static SamplesController getInstance() {
		return INSTANCE;
	}

	public List<SamplesItem> getItems() {
		return mItems;
	}
}
