package com.siteduzero.android.nfc;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

import com.siteduzero.android.R;

public class NFCBeamActivity extends Activity implements
		CreateNdefMessageCallback {
	private NfcAdapter mNfcAdapter;
	private TextView mTextViewNfc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc_beam);

		mTextViewNfc = (TextView) findViewById(R.id.textViewNfc);
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if (mNfcAdapter == null) {
			Toast.makeText(this, R.string.text_no_nfc, Toast.LENGTH_SHORT)
					.show();
			finish();
			return;
		}

		mNfcAdapter.setNdefPushMessageCallback(this, this);

		if (getIntent() != null) {
			resolveIntent(getIntent());
		}
	}

	@Override
	public void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		resolveIntent(intent);
	}

	private void resolveIntent(Intent intent) {
		String action = intent.getAction();
		if (action != null && action.equals(NfcAdapter.ACTION_NDEF_DISCOVERED)) {
			Parcelable[] rawMsgs = intent
					.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefMessage[] messages = null;
			if (rawMsgs != null) {
				messages = new NdefMessage[rawMsgs.length];
				for (int i = 0; i < rawMsgs.length; i++) {
					messages[i] = (NdefMessage) rawMsgs[i];
				}
				String str = new String(
						messages[0].getRecords()[0].getPayload());
				mTextViewNfc.setText(str);
			}
		}
	}

	@Override
	public NdefMessage createNdefMessage(NfcEvent event) {
		String text = "Message share by Beam !";
		NdefMessage msg = new NdefMessage(
				new NdefRecord[] { NFCUtils.createMimeRecord(
						"application/com.siteduzero.android.nfc",
						text.getBytes()) });
		return msg;
	}
}
