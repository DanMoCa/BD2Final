/*@lineinfo:filename=INFO_PUB*//*@lineinfo:user-code*//*@lineinfo:1^1*/package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;
import sqlj.runtime.ref.DefaultContext;
import sqlj.runtime.ConnectionContext;

public class INFO_PUB implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PUBS.INFO_PUB";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  /* connection management */
  protected Connection __onn = null;
  protected javax.sql.DataSource __dataSource = null;
  public void setDataSource(javax.sql.DataSource dataSource) throws SQLException
  { release(); __dataSource = dataSource; }
  public void setDataSourceLocation(String dataSourceLocation) throws SQLException {
    javax.sql.DataSource dataSource;
    try {
      Class cls = Class.forName("javax.naming.InitialContext");
      Object ctx = cls.newInstance();
      java.lang.reflect.Method meth = cls.getMethod("lookup", new Class[]{String.class});
      dataSource = (javax.sql.DataSource) meth.invoke(ctx, new Object[]{"java:comp/env/" + dataSourceLocation});
      setDataSource(dataSource);
    } catch (Exception e) {
      throw new java.sql.SQLException("Error initializing DataSource at " + dataSourceLocation + ": " + e.getMessage());
    }
  }
  public Connection getConnection() throws SQLException
  { 
    if (__onn!=null) return __onn;
     else if (__tx!=null) return __tx.getConnection(); 
     else if (__dataSource!=null) __onn= __dataSource.getConnection(); 
     return __onn; 
   } 
  public void release() throws SQLException
  { if (__tx!=null && __onn!=null) __tx.close(ConnectionContext.KEEP_CONNECTION);
    __onn = null; __tx = null;
    __dataSource = null;
  }

  public void closeConnection(){
    if (__dataSource!=null) {
      try { if (__onn!=null) { __onn.close(); } } catch (java.sql.SQLException e) {}
      try { if (__tx!=null) {__tx.close(); } } catch (java.sql.SQLException e) {}
      __onn=null;
      __tx=null;
    }
  }
  protected DefaultContext __tx = null;
  public void setConnectionContext(DefaultContext ctx) throws SQLException
  { release(); __tx = ctx; }
  public DefaultContext getConnectionContext() throws SQLException
  { if (__tx==null)
    { __tx = (getConnection()==null) ? DefaultContext.getDefaultContext() : new DefaultContext(getConnection()); }
    return __tx;
  };
  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 2006,2004,2005 };
  protected static ORADataFactory[] _factory = new ORADataFactory[3];
  static
  {
    _factory[0] = EDITORIALRef.getORADataFactory();
  }
  protected static final INFO_PUB _INFO_PUBFactory = new INFO_PUB();

  public static ORADataFactory getORADataFactory()
  { return _INFO_PUBFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[3], _sqlType, _factory); }
  public INFO_PUB()
  { _init_struct(true); __tx = DefaultContext.getDefaultContext(); }
  public INFO_PUB(DefaultContext c) /*throws SQLException*/
  { _init_struct(true); __tx = c; }
  public INFO_PUB(Connection c) /*throws SQLException*/
  { _init_struct(true); __onn = c; }
  public INFO_PUB(EDITORIALRef refPub, oracle.sql.BLOB logo, oracle.sql.CLOB prInfo) throws SQLException
  {
    _init_struct(true);
    setRefPub(refPub);
    setLogo(logo);
    setPrInfo(prInfo);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    if (__tx!=null && __onn!=c) release();
    __onn = c;
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  public void setFrom(INFO_PUB o) throws SQLException
  { setContextFrom(o); setValueFrom(o); }
  protected void setContextFrom(INFO_PUB o) throws SQLException
  { release(); __tx = o.__tx; __onn = o.__onn; }
  protected void setValueFrom(INFO_PUB o) { _struct = o._struct; }
  protected ORAData create(INFO_PUB o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) { if (o!=null) { o.release(); }; return null; }
    if (o == null) o = new INFO_PUB();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    o.__onn = ((STRUCT) d).getJavaSqlConnection();
    return o;
  }
  /* accessor methods */
  public EDITORIALRef getRefPub() throws SQLException
  { return (EDITORIALRef) _struct.getAttribute(0); }

  public void setRefPub(EDITORIALRef refPub) throws SQLException
  { _struct.setAttribute(0, refPub); }


  public oracle.sql.BLOB getLogo() throws SQLException
  { return (oracle.sql.BLOB) _struct.getOracleAttribute(1); }

  public void setLogo(oracle.sql.BLOB logo) throws SQLException
  { _struct.setOracleAttribute(1, logo); }


  public oracle.sql.CLOB getPrInfo() throws SQLException
  { return (oracle.sql.CLOB) _struct.getOracleAttribute(2); }

  public void setPrInfo(oracle.sql.CLOB prInfo) throws SQLException
  { _struct.setOracleAttribute(2, prInfo); }


  public INFO_PUB borrar ()
  throws java.sql.SQLException
  {
 try {
    INFO_PUB __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:146^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.BORRAR();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1  .BORRAR();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"0entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:150^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    INFO_PUB __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:158^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.BORRAR();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1  .BORRAR();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"1entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:162^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }

  public INFO_PUB buscar (
    EDITORIAL EDIT)
  throws java.sql.SQLException
  {
    INFO_PUB __jPt_result=null;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:177^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.INFO_PUB.BUSCAR(
//        :EDIT))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.INFO_PUB.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"2entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (EDIT==null) __sJT_st.setNull(2,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,EDIT);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:178^15*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:184^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.INFO_PUB.BUSCAR(
//        :EDIT))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.INFO_PUB.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"3entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (EDIT==null) __sJT_st.setNull(2,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,EDIT);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:185^15*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public INFO_PUBRef getref ()
  throws java.sql.SQLException
  {
    INFO_PUB __jPt_temp = (INFO_PUB) this;
    INFO_PUBRef __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:200^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := :__jPt_temp.GETREF();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   :=  :2  .GETREF();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"4entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUBRef)__sJT_st.getORAData(1,entidades.INFO_PUBRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:204^5*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:210^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := :__jPt_temp.GETREF();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   :=  :2  .GETREF();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"5entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUBRef)__sJT_st.getORAData(1,entidades.INFO_PUBRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:214^5*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public INFO_PUB guardar ()
  throws java.sql.SQLException
  {
 try {
    INFO_PUB __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:228^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.GUARDAR();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1  .GUARDAR();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"6entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:232^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    INFO_PUB __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:240^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.GUARDAR();
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1  .GUARDAR();\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"7entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.INFO_PUB"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:244^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }

  public INFO_PUB infoPub (
    EDITORIALRef REF_PUB,
    oracle.sql.BLOB LOGO,
    oracle.sql.CLOB PR_INFO,
    INFO_PUB __jPt_out[])
  throws java.sql.SQLException
  {
    INFO_PUB __jPt_temp = (INFO_PUB) this;
    INFO_PUB __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:263^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := INFO_PUB(
//        :REF_PUB,
//        :LOGO,
//        :PR_INFO);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := INFO_PUB(\n       :2  ,\n       :3  ,\n       :4  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"8entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (REF_PUB==null) __sJT_st.setNull(2,2006,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,REF_PUB);
   __sJT_st.setBLOB(3,LOGO);
   __sJT_st.setCLOB(4,PR_INFO);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:270^5*/
    __jPt_out[0] = __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:277^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := INFO_PUB(
//        :REF_PUB,
//        :LOGO,
//        :PR_INFO);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := INFO_PUB(\n       :2  ,\n       :3  ,\n       :4  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"9entidades.INFO_PUB",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.INFO_PUB");
   }
   // set IN parameters
   if (REF_PUB==null) __sJT_st.setNull(2,2006,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,REF_PUB);
   __sJT_st.setBLOB(3,LOGO);
   __sJT_st.setCLOB(4,PR_INFO);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.INFO_PUB)__sJT_st.getORAData(1,entidades.INFO_PUB.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:284^5*/
    __jPt_out[0] = __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }
}/*@lineinfo:generated-code*/