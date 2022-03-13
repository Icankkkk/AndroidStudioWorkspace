package com.icang.myintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    // property
    private String name, email, city;
    private int age;

    // constructor
    public Person() {}

    // getter
    public String getName() { return  name; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
    public int getAge() { return age; }

    // setter
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCity(String city) { this.city = city; }
    public void setAge(int age) { this.age = age; }

    protected Person(Parcel in) {
        name = in.readString();
        email = in.readString();
        city = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(city);
        parcel.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}

