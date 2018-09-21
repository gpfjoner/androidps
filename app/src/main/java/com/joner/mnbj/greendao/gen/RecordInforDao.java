package com.joner.mnbj.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.joner.mnbj.widget.RecordInfor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RECORD_INFOR".
*/
public class RecordInforDao extends AbstractDao<RecordInfor, Long> {

    public static final String TABLENAME = "RECORD_INFOR";

    /**
     * Properties of entity RecordInfor.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Money_type = new Property(2, int.class, "money_type", false, "MONEY_TYPE");
        public final static Property Money = new Property(3, long.class, "money", false, "MONEY");
        public final static Property Input_time = new Property(4, String.class, "input_time", false, "INPUT_TIME");
        public final static Property Content = new Property(5, String.class, "content", false, "CONTENT");
        public final static Property Type = new Property(6, String.class, "type", false, "TYPE");
    }


    public RecordInforDao(DaoConfig config) {
        super(config);
    }
    
    public RecordInforDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RECORD_INFOR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"MONEY_TYPE\" INTEGER NOT NULL ," + // 2: money_type
                "\"MONEY\" INTEGER NOT NULL ," + // 3: money
                "\"INPUT_TIME\" TEXT," + // 4: input_time
                "\"CONTENT\" TEXT," + // 5: content
                "\"TYPE\" TEXT);"); // 6: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RECORD_INFOR\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RecordInfor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getMoney_type());
        stmt.bindLong(4, entity.getMoney());
 
        String input_time = entity.getInput_time();
        if (input_time != null) {
            stmt.bindString(5, input_time);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(7, type);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RecordInfor entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getMoney_type());
        stmt.bindLong(4, entity.getMoney());
 
        String input_time = entity.getInput_time();
        if (input_time != null) {
            stmt.bindString(5, input_time);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(7, type);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RecordInfor readEntity(Cursor cursor, int offset) {
        RecordInfor entity = new RecordInfor( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // money_type
            cursor.getLong(offset + 3), // money
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // input_time
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // content
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RecordInfor entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMoney_type(cursor.getInt(offset + 2));
        entity.setMoney(cursor.getLong(offset + 3));
        entity.setInput_time(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setContent(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setType(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RecordInfor entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RecordInfor entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RecordInfor entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}