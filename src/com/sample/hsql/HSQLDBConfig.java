package com.sample.hsql;

/**
 * ���ݿ������Ϣ
 */
public class HSQLDBConfig {
	//���ݿ�����
	public static final String DBNAME = "bookDB";
	//���ݿ�·��
	public static final String DBPATH = "WEB-INF/db/";
	//���ݿ�˿�
	public static final int DBPORT = 9001;
	//�ű��ļ�����
	public static final String SCRIPTFILE = DBPATH + DBNAME + ".script";
	//�����ļ�����
	public static final String PROPERTIESFILE = DBPATH + DBNAME + ".properties";
	//URL
	public static final String URL = "jdbc:hsqldb:hsql://localhost:"+DBPORT+"/"+DBNAME;
	//�û���
	public static final String USERNAME = "sa";
	//����
	public static final String PASSWORD = "";
	//����
	public static final String DRIVER = "org.hsqldb.jdbcDriver";
}
