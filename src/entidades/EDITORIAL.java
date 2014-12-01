/*@lineinfo:filename=EDITORIAL*//*@lineinfo:user-code*//*@lineinfo:1^1*/package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;
import sqlj.runtime.ref.DefaultContext;
import sqlj.runtime.ConnectionContext;

public class EDITORIAL implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PUBS.EDITORIAL";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

   @Override
    public String toString() {
        try {
            return getPubId();
        } catch (SQLException ex) {
            Logger.getLogger(EDITORIAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
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

  protected static int[] _sqlType =  { 1,12,12,1,12 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  protected static final EDITORIAL _EDITORIALFactory = new EDITORIAL();

  public static ORADataFactory getORADataFactory()
  { return _EDITORIALFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  public EDITORIAL()
  { _init_struct(true); __tx = DefaultContext.getDefaultContext(); }
  public EDITORIAL(DefaultContext c) /*throws SQLException*/
  { _init_struct(true); __tx = c; }
  public EDITORIAL(Connection c) /*throws SQLException*/
  { _init_struct(true); __onn = c; }
  public EDITORIAL(String pubId, String pubName, String city, String state, String country) throws SQLException
  {
    _init_struct(true);
    setPubId(pubId);
    setPubName(pubName);
    setCity(city);
    setState(state);
    setCountry(country);
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
  public void setFrom(EDITORIAL o) throws SQLException
  { setContextFrom(o); setValueFrom(o); }
  protected void setContextFrom(EDITORIAL o) throws SQLException
  { release(); __tx = o.__tx; __onn = o.__onn; }
  protected void setValueFrom(EDITORIAL o) { _struct = o._struct; }
  protected ORAData create(EDITORIAL o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) { if (o!=null) { o.release(); }; return null; }
    if (o == null) o = new EDITORIAL();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    o.__onn = ((STRUCT) d).getJavaSqlConnection();
    return o;
  }
  /* accessor methods */
  public String getPubId() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setPubId(String pubId) throws SQLException
  { _struct.setAttribute(0, pubId); }


  public String getPubName() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setPubName(String pubName) throws SQLException
  { _struct.setAttribute(1, pubName); }


  public String getCity() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setCity(String city) throws SQLException
  { _struct.setAttribute(2, city); }


  public String getState() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setState(String state) throws SQLException
  { _struct.setAttribute(3, state); }


  public String getCountry() throws SQLException
  { return (String) _struct.getAttribute(4); }

  public void setCountry(String country) throws SQLException
  { _struct.setAttribute(4, country); }


  public EDITORIAL borrar ()
  throws java.sql.SQLException
  {
 try {
    EDITORIAL __jPt_temp = this;
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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"0entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:162^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    EDITORIAL __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:170^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"1entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:174^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }

  public EDITORIAL buscar (
    String IDI)
  throws java.sql.SQLException
  {
    EDITORIAL __jPt_result=null;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:189^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.EDITORIAL.BUSCAR(
//        :IDI))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.EDITORIAL.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"2entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   __sJT_st.setString(2,IDI);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:190^14*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:196^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.EDITORIAL.BUSCAR(
//        :IDI))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.EDITORIAL.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"3entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   __sJT_st.setString(2,IDI);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:197^14*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public EDITORIAL editorial (
    String PUB_ID,
    String PUB_NAME,
    String CITY,
    String STATE,
    String COUNTRY,
    EDITORIAL __jPt_out[])
  throws java.sql.SQLException
  {
    EDITORIAL __jPt_temp = (EDITORIAL) this;
    EDITORIAL __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:218^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := EDITORIAL(
//        :PUB_ID,
//        :PUB_NAME,
//        :CITY,
//        :STATE,
//        :COUNTRY);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := EDITORIAL(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"4entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   __sJT_st.setString(2,PUB_ID);
   __sJT_st.setString(3,PUB_NAME);
   __sJT_st.setString(4,CITY);
   __sJT_st.setString(5,STATE);
   __sJT_st.setString(6,COUNTRY);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:227^5*/
    __jPt_out[0] = __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:234^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := EDITORIAL(
//        :PUB_ID,
//        :PUB_NAME,
//        :CITY,
//        :STATE,
//        :COUNTRY);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := EDITORIAL(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"5entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   __sJT_st.setString(2,PUB_ID);
   __sJT_st.setString(3,PUB_NAME);
   __sJT_st.setString(4,CITY);
   __sJT_st.setString(5,STATE);
   __sJT_st.setString(6,COUNTRY);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:243^5*/
    __jPt_out[0] = __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public EDITORIALRef getref ()
  throws java.sql.SQLException
  {
    EDITORIAL __jPt_temp = (EDITORIAL) this;
    EDITORIALRef __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:259^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"6entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIALRef)__sJT_st.getORAData(1,entidades.EDITORIALRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:263^5*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:269^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"7entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.EDITORIALRef)__sJT_st.getORAData(1,entidades.EDITORIALRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:273^5*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public EDITORIAL guardar ()
  throws java.sql.SQLException
  {
 try {
    EDITORIAL __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:287^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"8entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:291^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    EDITORIAL __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:299^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"9entidades.EDITORIAL",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.EDITORIAL");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.EDITORIAL"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.EDITORIAL)__sJT_st.getORAData(1,entidades.EDITORIAL.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:303^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }
}/*@lineinfo:generated-code*/