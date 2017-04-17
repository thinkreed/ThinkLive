package com.reed.live.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thinkreed on 2017/4/13.
 */

public class Model implements Parcelable {
  private Repository repository;

  private Model(Builder builder) {
    setRepository(builder.repository);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(Model copy) {
    Builder builder = new Builder();
    builder.repository = copy.repository;
    return builder;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.repository, flags);
  }

  public Model() {}

  protected Model(Parcel in) {
    this.repository = in.readParcelable(Repository.class.getClassLoader());
  }

  public static final Creator<Model> CREATOR = new Creator<Model>() {
    @Override
    public Model createFromParcel(Parcel source) {
      return new Model(source);
    }

    @Override
    public Model[] newArray(int size) {
      return new Model[size];
    }
  };

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Model model = (Model) o;

    return repository != null ? repository.equals(model.repository) : model.repository == null;
  }

  @Override
  public int hashCode() {
    return repository != null ? repository.hashCode() : 0;
  }

  public Repository getRepository() {
    return repository;
  }

  public void setRepository(Repository repository) {
    this.repository = repository;
  }

  public static Creator<Model> getCREATOR() {
    return CREATOR;
  }

  @Override
  public String toString() {
    return "Model{" + "repository=" + repository + '}';
  }

  /**
   * {@code Model} builder static inner class.
   */
  public static final class Builder {
    private Repository repository;

    private Builder() {}

    /**
     * Sets the {@code repository} and returns a reference to this Builder so that the methods can
     * be chained together.
     *
     * @param val the {@code repository} to set
     * @return a reference to this Builder
     */
    public Builder repository(Repository val) {
      repository = val;
      return this;
    }

    /**
     * Returns a {@code Model} built from the parameters previously set.
     *
     * @return a {@code Model} built with parameters of this {@code Model.Builder}
     */
    public Model build() {
      return new Model(this);
    }
  }
}
