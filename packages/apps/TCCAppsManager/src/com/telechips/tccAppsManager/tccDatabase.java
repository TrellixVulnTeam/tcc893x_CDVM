package com.telechips.tccAppsManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class tccDatabase {

	private static final String DATABASE_NAME = "cometelechipsfavorite.db";
	private static final int DATABASE_VERSION = 1;
	public static SQLiteDatabase mDB;
	private DatabaseHelper mDBHelper;
	private Context mCtx;
	
	private class DatabaseHelper extends SQLiteOpenHelper{

		// ������
		public DatabaseHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		// ���� DB�� ���鶧 �ѹ��� ȣ��ȴ�.
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(tccDatabaseItem.CreateDB._CREATE);
			
				
		}

		// ������ ������Ʈ �Ǿ��� ��� DB�� �ٽ� ����� �ش�.
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS "+tccDatabaseItem.CreateDB._TABLENAME);
			onCreate(db);
		}
	}	
	public tccDatabase(Context context){
		this.mCtx = context;
	}
	public tccDatabase open() throws SQLException{
		mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
		mDB = mDBHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		mDB.close();
	}
	// Insert DB
	public long insertColumn(String name, String uniq_name){
		ContentValues values = new ContentValues();
		values.put(tccDatabaseItem.CreateDB.NAME, name);
		values.put(tccDatabaseItem.CreateDB.UNIQ, uniq_name);
		return mDB.insert(tccDatabaseItem.CreateDB._TABLENAME, null, values);
	}
	// Update DB
	public boolean updateColumn(long id , String name, String contact, String email){
		ContentValues values = new ContentValues();
		values.put(tccDatabaseItem.CreateDB.NAME, name);
		return mDB.update(tccDatabaseItem.CreateDB._TABLENAME, values, "_id="+id, null) > 0;
	}

	// Delete ID
	public boolean deleteColumn(long id){
		return mDB.delete(tccDatabaseItem.CreateDB._TABLENAME, "_id="+id, null) > 0;
	}
	// Select All
	public Cursor getAllColumns(){
		return mDB.query(tccDatabaseItem.CreateDB._TABLENAME, null, null, null, null, null, null);
	}
	// ID �÷� ��� ����
	public Cursor getColumn(long id){
		Cursor c = mDB.query(tccDatabaseItem.CreateDB._TABLENAME, null, 
				"_id="+id, null, null, null, null);
		if(c != null && c.getCount() != 0)
			c.moveToFirst();
		return c;
	}

	// �̸� �˻� �ϱ� (rawQuery)
	public Cursor getMatchName(String name){
		Cursor c = mDB.rawQuery( "select * from FavoriteItem where Apkname=" + "'" + name + "'" , null);
		return c;
	}
	//uniq Apk�˻� �ϱ� 
	public Cursor getMatchUniqName(String name){
		Cursor c = mDB.rawQuery( "select * from FavoriteItem where UniqApk=" + "'" + name + "'" , null);
		return c;
	}
}
