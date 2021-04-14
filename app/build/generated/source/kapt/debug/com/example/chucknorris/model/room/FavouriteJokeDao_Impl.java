package com.example.chucknorris.model.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.chucknorris.model.models.FavouriteJoke;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouriteJokeDao_Impl implements FavouriteJokeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouriteJoke> __insertionAdapterOfFavouriteJoke;

  private final EntityDeletionOrUpdateAdapter<FavouriteJoke> __deletionAdapterOfFavouriteJoke;

  private final EntityDeletionOrUpdateAdapter<FavouriteJoke> __updateAdapterOfFavouriteJoke;

  public FavouriteJokeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouriteJoke = new EntityInsertionAdapter<FavouriteJoke>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `FavouriteJoke` (`id`,`createdAt`,`iconUrl`,`updatedAt`,`url`,`value`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteJoke value) {
        stmt.bindLong(1, value.getId());
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCreatedAt());
        }
        if (value.getIconUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIconUrl());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUpdatedAt());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
        if (value.getValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getValue());
        }
      }
    };
    this.__deletionAdapterOfFavouriteJoke = new EntityDeletionOrUpdateAdapter<FavouriteJoke>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FavouriteJoke` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteJoke value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfFavouriteJoke = new EntityDeletionOrUpdateAdapter<FavouriteJoke>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FavouriteJoke` SET `id` = ?,`createdAt` = ?,`iconUrl` = ?,`updatedAt` = ?,`url` = ?,`value` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteJoke value) {
        stmt.bindLong(1, value.getId());
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCreatedAt());
        }
        if (value.getIconUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIconUrl());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUpdatedAt());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
        if (value.getValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getValue());
        }
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public Object insert(final FavouriteJoke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavouriteJoke.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insert(final List<? extends FavouriteJoke> entities,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavouriteJoke.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final FavouriteJoke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavouriteJoke.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final List<? extends FavouriteJoke> entities,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavouriteJoke.handleMultiple(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final FavouriteJoke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFavouriteJoke.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final List<? extends FavouriteJoke> entities,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFavouriteJoke.handleMultiple(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object findByValue(final String value, final Continuation<? super FavouriteJoke> p1) {
    final String _sql = "SELECT * FROM favouritejoke WHERE value = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (value == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, value);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<FavouriteJoke>() {
      @Override
      public FavouriteJoke call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIconUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "iconUrl");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final FavouriteJoke _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpIconUrl;
            _tmpIconUrl = _cursor.getString(_cursorIndexOfIconUrl);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpValue;
            _tmpValue = _cursor.getString(_cursorIndexOfValue);
            _result = new FavouriteJoke(_tmpCreatedAt,_tmpIconUrl,_tmpUpdatedAt,_tmpUrl,_tmpValue);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<FavouriteJoke>> readAll() {
    final String _sql = "SELECT * FROM favouritejoke";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"favouritejoke"}, false, new Callable<List<FavouriteJoke>>() {
      @Override
      public List<FavouriteJoke> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIconUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "iconUrl");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final List<FavouriteJoke> _result = new ArrayList<FavouriteJoke>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FavouriteJoke _item;
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpIconUrl;
            _tmpIconUrl = _cursor.getString(_cursorIndexOfIconUrl);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpValue;
            _tmpValue = _cursor.getString(_cursorIndexOfValue);
            _item = new FavouriteJoke(_tmpCreatedAt,_tmpIconUrl,_tmpUpdatedAt,_tmpUrl,_tmpValue);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
