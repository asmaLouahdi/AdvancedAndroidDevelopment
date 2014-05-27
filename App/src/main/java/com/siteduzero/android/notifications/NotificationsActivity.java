package com.siteduzero.android.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.view.View;

import com.siteduzero.android.R;

public class NotificationsActivity extends Activity {
	private NotificationManager mNotificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	public void onClickBasic(View v) {
		Builder builder = new NotificationCompat.Builder(this);
		Notification notification = builder
				.setContentTitle(getResources().getText(R.string.basic_title))
				.setContentText(getResources().getText(R.string.basic_text))
				.setSmallIcon(R.drawable.ic_launcher)
				.setWhen(System.currentTimeMillis()).build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(0, notification);
	}

	public void onClickBigText(View v) {
		Builder builder = new NotificationCompat.Builder(this);
		builder.setContentTitle(getResources().getText(R.string.big_text_title))
				.setSmallIcon(R.drawable.ic_launcher)
				.addAction(android.R.drawable.ic_menu_camera,
						getResources().getText(R.string.notification_action_2),
						getPendingIntent())
				.addAction(android.R.drawable.ic_menu_send,
						getResources().getText(R.string.notification_action_1),
						getPendingIntent()).setWhen(System.currentTimeMillis());
		BigTextStyle bigText = new NotificationCompat.BigTextStyle(builder);
		bigText.bigText(getResources().getText(R.string.big_text));
		Notification notification = bigText.build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(0, notification);
	}

	public void onClickBigPicture(View v) {
		Builder builder = new NotificationCompat.Builder(this);
		builder.setContentTitle(getResources().getText(R.string.big_pic_title))
				.setSmallIcon(R.drawable.ic_launcher)
				.addAction(android.R.drawable.ic_menu_camera,
						getResources().getText(R.string.notification_action_2),
						getPendingIntent())
				.addAction(android.R.drawable.ic_menu_send,
						getResources().getText(R.string.notification_action_1),
						getPendingIntent()).setWhen(System.currentTimeMillis());
		BigPictureStyle bigPic = new NotificationCompat.BigPictureStyle(builder);
		Notification notification = bigPic.bigPicture(
				BitmapFactory.decodeResource(getResources(),
						R.drawable.notif_big_pic)).build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(0, notification);
	}

	public void onClickInBox(View v) {
		Builder builder = new NotificationCompat.Builder(this);
		builder.setContentTitle(getResources().getText(R.string.inbox_title))
				.setSmallIcon(R.drawable.ic_launcher)
				.addAction(android.R.drawable.ic_menu_camera,
						getResources().getText(R.string.notification_action_2),
						getPendingIntent())
				.addAction(android.R.drawable.ic_menu_send,
						getResources().getText(R.string.notification_action_1),
						getPendingIntent()).setWhen(System.currentTimeMillis());
		InboxStyle inbox = new NotificationCompat.InboxStyle(builder);
		Notification notification = inbox.addLine("Line 1").addLine("Line 2")
				.setSummaryText("You have 2 messages").build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(0, notification);
	}

	private PendingIntent getPendingIntent() {
		Intent intent = new Intent(this, NotificationsActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return PendingIntent.getActivity(this, 0, intent, 0);
	}
}
