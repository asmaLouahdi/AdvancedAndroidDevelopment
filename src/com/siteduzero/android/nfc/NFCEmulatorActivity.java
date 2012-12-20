package com.siteduzero.android.nfc;

import com.siteduzero.android.R;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;

public class NFCEmulatorActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc_emulator);
	}

	public void sendTag(View v) {
		Intent i = new Intent(NfcAdapter.ACTION_NDEF_DISCOVERED);
		NdefMessage[] messages = new NdefMessage[1];
		messages[0] = NFCUtils.createMessage("Simule message NDEF", true);
		i.putExtra(NfcAdapter.EXTRA_NDEF_MESSAGES, messages);
		startActivity(i);
	}
}
