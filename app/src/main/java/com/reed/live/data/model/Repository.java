package com.reed.live.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thinkreed on 2017/4/10.
 */

public class Repository implements Parcelable {

  private Long id;
  private String name;
  private String description;

  @Override
  public String toString() {
    return "Repository{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Repository that = (Repository) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return description != null ? description.equals(that.description) : that.description == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  private Repository(Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setDescription(builder.description);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(Repository copy) {
    Builder builder = new Builder();
    builder.id = copy.id;
    builder.name = copy.name;
    builder.description = copy.description;
    return builder;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Repository() {}

  /**
   * {@code Repository} builder static inner class.
   */
  public static final class Builder {
    private Long id;
    private String name;
    private String description;

    private Builder() {}

    /**
     * Sets the {@code id} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param val the {@code id} to set
     * @return a reference to this Builder
     */
    public Builder id(Long val) {
      id = val;
      return this;
    }

    /**
     * Sets the {@code name} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param val the {@code name} to set
     * @return a reference to this Builder
     */
    public Builder name(String val) {
      name = val;
      return this;
    }

    /**
     * Sets the {@code description} and returns a reference to this Builder so that the methods can
     * be chained together.
     *
     * @param val the {@code description} to set
     * @return a reference to this Builder
     */
    public Builder description(String val) {
      description = val;
      return this;
    }

    /**
     * Returns a {@code Repository} built from the parameters previously set.
     *
     * @return a {@code Repository} built with parameters of this {@code Repository.Builder}
     */
    public Repository build() {
      return new Repository(this);
    }
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.id);
    dest.writeString(this.name);
    dest.writeString(this.description);
  }

  protected Repository(Parcel in) {
    this.id = (Long) in.readValue(Long.class.getClassLoader());
    this.name = in.readString();
    this.description = in.readString();
  }

  public static final Creator<Repository> CREATOR = new Creator<Repository>() {
    @Override
    public Repository createFromParcel(Parcel source) {
      return new Repository(source);
    }

    @Override
    public Repository[] newArray(int size) {
      return new Repository[size];
    }
  };
}
