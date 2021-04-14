package com.example.chucknorris.model.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.chucknorris.model.models.Joke;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class JokeDao_Impl implements JokeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Joke> __insertionAdapterOfJoke;

  private final EntityDeletionOrUpdateAdapter<Joke> __deletionAdapterOfJoke;

  private final EntityDeletionOrUpdateAdapter<Joke> __updateAdapterOfJoke;

  public JokeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJoke = new EntityInsertionAdapter<Joke>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Joke` (`id`,`createdAt`,`iconUrl`,`updatedAt`,`url`,`value`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Joke value) {
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
    this.__deletionAdapterOfJoke = new EntityDeletionOrUpdateAdapter<Joke>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Joke` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Joke value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfJoke = new EntityDeletionOrUpdateAdapter<Joke>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Joke` SET `id` = ?,`createdAt` = ?,`iconUrl` = ?,`updatedAt` = ?,`url` = ?,`value` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Joke value) {
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
  public Object insert(final Joke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfJoke.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insert(final List<? extends Joke> entities, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfJoke.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final Joke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfJoke.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final List<? extends Joke> entities, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfJoke.handleMultiple(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final Joke entity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfJoke.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final List<? extends Joke> entities, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfJoke.handleMultiple(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object findByValue(final String value, final Continuation<? super Joke> p1) {
    final String _sql = "SELECT * FROM joke WHERE value = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (value == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, value);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<Joke>() {
      @Override
      public Joke call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIconUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "iconUrl");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final Joke _result;
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
            _result = new Joke(_tmpCreatedAt,_tmpIconUrl,_tmpUpdatedAt,_tmpUrl,_tmpValue);
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
  public Object specialQuery(final SupportSQLiteQuery query, final Continuation<? super Joke> p1) {
    final SupportSQLiteQuery _internalQuery = query;
    return CoroutinesRoom.execute(__db, false, new Callable<Joke>() {
      @Override
      public Joke call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _internalQuery, false, null);
        try {
          final Joke _result;
          if(_cursor.moveToFirst()) {
            _result = __entityCursorConverter_comExampleChucknorrisModelModelsJoke(_cursor);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }
    }, p1);
  }

  private Joke __entityCursorConverter_comExampleChucknorrisModelModelsJoke(Cursor cursor) {
    final Joke _entity;
    final int _cursorIndexOfId = cursor.getColumnIndex("id");
    final int _cursorIndexOfCreatedAt = cursor.getColumnIndex("createdAt");
    final int _cursorIndexOfIconUrl = cursor.getColumnIndex("iconUrl");
    final int _cursorIndexOfUpdatedAt = cursor.getColumnIndex("updatedAt");
    final int _cursorIndexOfUrl = cursor.getColumnIndex("url");
    final int _cursorIndexOfValue = cursor.getColumnIndex("value");
    final String _tmpCreatedAt;
    if (_cursorIndexOfCreatedAt == -1) {
      _tmpCreatedAt = null;
    } else {
      _tmpCreatedAt = cursor.getString(_cursorIndexOfCreatedAt);
    }
    final String _tmpIconUrl;
    if (_cursorIndexOfIconUrl == -1) {
      _tmpIconUrl = null;
    } else {
      _tmpIconUrl = cursor.getString(_cursorIndexOfIconUrl);
    }
    final String _tmpUpdatedAt;
    if (_cursorIndexOfUpdatedAt == -1) {
      _tmpUpdatedAt = null;
    } else {
      _tmpUpdatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
    }
    final String _tmpUrl;
    if (_cursorIndexOfUrl == -1) {
      _tmpUrl = null;
    } else {
      _tmpUrl = cursor.getString(_cursorIndexOfUrl);
    }
    final String _tmpValue;
    if (_cursorIndexOfValue == -1) {
      _tmpValue = null;
    } else {
      _tmpValue = cursor.getString(_cursorIndexOfValue);
    }
    _entity = new Joke(_tmpCreatedAt,_tmpIconUrl,_tmpUpdatedAt,_tmpUrl,_tmpValue);
    if (_cursorIndexOfId != -1) {
      final int _tmpId;
      _tmpId = cursor.getInt(_cursorIndexOfId);
      _entity.setId(_tmpId);
    }
    return _entity;
  }
}
