package com.example.chucknorris.view.search;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.chucknorris.R;
import com.example.chucknorris.model.models.Joke;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SearchListFragmentDirections {
  private SearchListFragmentDirections() {
  }

  @NonNull
  public static ActionSearchListFragmentToJokeDetailsFragment2 actionSearchListFragmentToJokeDetailsFragment2(
      @NonNull Joke joke) {
    return new ActionSearchListFragmentToJokeDetailsFragment2(joke);
  }

  public static class ActionSearchListFragmentToJokeDetailsFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSearchListFragmentToJokeDetailsFragment2(@NonNull Joke joke) {
      if (joke == null) {
        throw new IllegalArgumentException("Argument \"joke\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("joke", joke);
    }

    @NonNull
    public ActionSearchListFragmentToJokeDetailsFragment2 setJoke(@NonNull Joke joke) {
      if (joke == null) {
        throw new IllegalArgumentException("Argument \"joke\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("joke", joke);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_searchListFragment_to_jokeDetailsFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Joke getJoke() {
      return (Joke) arguments.get("joke");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSearchListFragmentToJokeDetailsFragment2 that = (ActionSearchListFragmentToJokeDetailsFragment2) object;
      if (arguments.containsKey("joke") != that.arguments.containsKey("joke")) {
        return false;
      }
      if (getJoke() != null ? !getJoke().equals(that.getJoke()) : that.getJoke() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getJoke() != null ? getJoke().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSearchListFragmentToJokeDetailsFragment2(actionId=" + getActionId() + "){"
          + "joke=" + getJoke()
          + "}";
    }
  }
}
