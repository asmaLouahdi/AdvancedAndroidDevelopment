package org.randoomz.demo.samples.common;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
  public final int title;
  public final Class<? extends Activity> activityToStart;

  public Item(int title, Class<? extends Activity> activityToStart) {
    super();
    this.title = title;
    this.activityToStart = activityToStart;
  }

  protected Item(Parcel in) {
    this.title = in.readInt();
    final String className = in.readString();
    try {
      this.activityToStart = (Class<? extends Activity>) Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Can't find " + className);
    }
  }

  public static final Creator<Item> CREATOR = new Creator<Item>() {
    @Override
    public Item createFromParcel(Parcel in) {
      return new Item(in);
    }

    @Override
    public Item[] newArray(int size) {
      return new Item[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(title);
    parcel.writeString(activityToStart.getCanonicalName());
  }
}
