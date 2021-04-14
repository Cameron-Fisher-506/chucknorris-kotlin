package com.example.chucknorris.view.jokes;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.example.chucknorris.model.models.Joke;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class JokeDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private JokeDetailsFragmentArgs() {
  }

  private JokeDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static JokeDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    JokeDetailsFragmentArgs __result = new JokeDetailsFragmentArgs();
    bundle.setClassLoader(JokeDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("joke")) {
      Joke joke;
      if (Parcelable.class.isAssignableFrom(Joke.class) || Serializable.class.isAssignableFrom(Joke.class)) {
        joke = (Joke) bundle.get("joke");
      } else {
        throw new UnsupportedOperationException(Joke.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (joke == null) {
        throw new IllegalArgumentException("Argument \"joke\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("joke", joke);
    } else {
      throw new IllegalArgumentException("Required argument \"joke\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Joke getJoke() {
    return (Joke) arguments.get("joke");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("joke")) {
      Joke joke = (Joke) arguments.get("joke");
      if (Parcelable.class.isAssignableFrom(Joke.class) || joke == null) {
        __result.putParcelable("joke", Parcelable.class.cast(joke));
      } else if (Serializable.class.isAssignableFrom(Joke.class)) {
        __result.putSerializable("joke", Serializable.class.cast(joke));
      } else {
        throw new UnsupportedOperationException(Joke.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    JokeDetailsFragmentArgs that = (JokeDetailsFragmentArgs) object;
    if (arguments.containsKey("joke") != that.arguments.containsKey("joke")) {
      return false;
    }
    if (getJoke() != null ? !getJoke().equals(that.getJoke()) : that.getJoke() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getJoke() != null ? getJoke().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "JokeDetailsFragmentArgs{"
        + "joke=" + getJoke()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(JokeDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Joke joke) {
      if (joke == null) {
        throw new IllegalArgumentException("Argument \"joke\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("joke", joke);
    }

    @NonNull
    public JokeDetailsFragmentArgs build() {
      JokeDetailsFragmentArgs result = new JokeDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setJoke(@NonNull Joke joke) {
      if (joke == null) {
        throw new IllegalArgumentException("Argument \"joke\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("joke", joke);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Joke getJoke() {
      return (Joke) arguments.get("joke");
    }
  }
}
