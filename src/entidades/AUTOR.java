/*@lineinfo:filename=AUTOR*//*@lineinfo:user-code*//*@lineinfo:1^1*/package entidades;

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

public class AUTOR implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PUBS.AUTOR";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

@Override
    public String toString() {
        try {
            return getAuId();
        } catch (SQLException ex) {
            Logger.getLogger(AUTOR.class.getName()).log(Level.SEVERE, null, ex);
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

  protected static int[] _sqlType =  { 12,12,12,1,12,12,1,1,2 };
  protected static ORADataFactory[] _factory = new ORADataFactory[9];
  protected static final AUTOR _AUTORFactory = new AUTOR();

  public static ORADataFactory getORADataFactory()
  { return _AUTORFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[9], _sqlType, _factory); }
  public AUTOR()
  { _init_struct(true); __tx = DefaultContext.getDefaultContext(); }
  public AUTOR(DefaultContext c) /*throws SQLException*/
  { _init_struct(true); __tx = c; }
  public AUTOR(Connection c) /*throws SQLException*/
  { _init_struct(true); __onn = c; }
  public AUTOR(String auId, String auLname, String auFname, String phone, String address, String city, String state, String zip, java.math.BigDecimal contract) throws SQLException
  {
    _init_struct(true);
    setAuId(auId);
    setAuLname(auLname);
    setAuFname(auFname);
    setPhone(phone);
    setAddress(address);
    setCity(city);
    setState(state);
    setZip(zip);
    setContract(contract);
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
  public void setFrom(AUTOR o) throws SQLException
  { setContextFrom(o); setValueFrom(o); }
  protected void setContextFrom(AUTOR o) throws SQLException
  { release(); __tx = o.__tx; __onn = o.__onn; }
  protected void setValueFrom(AUTOR o) { _struct = o._struct; }
  protected ORAData create(AUTOR o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) { if (o!=null) { o.release(); }; return null; }
    if (o == null) o = new AUTOR();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    o.__onn = ((STRUCT) d).getJavaSqlConnection();
    return o;
  }
  /* accessor methods */
  public String getAuId() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setAuId(String auId) throws SQLException
  { _struct.setAttribute(0, auId); }


  public String getAuLname() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setAuLname(String auLname) throws SQLException
  { _struct.setAttribute(1, auLname); }


  public String getAuFname() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setAuFname(String auFname) throws SQLException
  { _struct.setAttribute(2, auFname); }


  public String getPhone() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setPhone(String phone) throws SQLException
  { _struct.setAttribute(3, phone); }


  public String getAddress() throws SQLException
  { return (String) _struct.getAttribute(4); }

  public void setAddress(String address) throws SQLException
  { _struct.setAttribute(4, address); }


  public String getCity() throws SQLException
  { return (String) _struct.getAttribute(5); }

  public void setCity(String city) throws SQLException
  { _struct.setAttribute(5, city); }


  public String getState() throws SQLException
  { return (String) _struct.getAttribute(6); }

  public void setState(String state) throws SQLException
  { _struct.setAttribute(6, state); }


  public String getZip() throws SQLException
  { return (String) _struct.getAttribute(7); }

  public void setZip(String zip) throws SQLException
  { _struct.setAttribute(7, zip); }


  public java.math.BigDecimal getContract() throws SQLException
  { return (java.math.BigDecimal) _struct.getAttribute(8); }

  public void setContract(java.math.BigDecimal contract) throws SQLException
  { _struct.setAttribute(8, contract); }


  public AUTOR autor (
    String AU_ID,
    String AU_LNAME,
    String AU_FNAME,
    String PHONE,
    String ADDRESS,
    String CITY,
    String STATE,
    String ZIP,
    java.math.BigDecimal CONTRACT,
    AUTOR __jPt_out[])
  throws java.sql.SQLException
  {
    AUTOR __jPt_temp = (AUTOR) this;
    AUTOR __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:201^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := AUTOR(
//        :AU_ID,
//        :AU_LNAME,
//        :AU_FNAME,
//        :PHONE,
//        :ADDRESS,
//        :CITY,
//        :STATE,
//        :ZIP,
//        :CONTRACT);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := AUTOR(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  ,\n       :8  ,\n       :9  ,\n       :10  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"0entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   __sJT_st.setString(2,AU_ID);
   __sJT_st.setString(3,AU_LNAME);
   __sJT_st.setString(4,AU_FNAME);
   __sJT_st.setString(5,PHONE);
   __sJT_st.setString(6,ADDRESS);
   __sJT_st.setString(7,CITY);
   __sJT_st.setString(8,STATE);
   __sJT_st.setString(9,ZIP);
   __sJT_st.setBigDecimal(10,CONTRACT);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:214^5*/
    __jPt_out[0] = __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:221^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := AUTOR(
//        :AU_ID,
//        :AU_LNAME,
//        :AU_FNAME,
//        :PHONE,
//        :ADDRESS,
//        :CITY,
//        :STATE,
//        :ZIP,
//        :CONTRACT);
//        END;
//       };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN\n       :1   := AUTOR(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  ,\n       :8  ,\n       :9  ,\n       :10  );\n      END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"1entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   __sJT_st.setString(2,AU_ID);
   __sJT_st.setString(3,AU_LNAME);
   __sJT_st.setString(4,AU_FNAME);
   __sJT_st.setString(5,PHONE);
   __sJT_st.setString(6,ADDRESS);
   __sJT_st.setString(7,CITY);
   __sJT_st.setString(8,STATE);
   __sJT_st.setString(9,ZIP);
   __sJT_st.setBigDecimal(10,CONTRACT);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:234^5*/
    __jPt_out[0] = __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public AUTOR borrar ()
  throws java.sql.SQLException
  {
 try {
    AUTOR __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:249^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"2entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:253^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    AUTOR __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:261^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"3entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:265^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }

  public AUTOR buscar (
    String IDI)
  throws java.sql.SQLException
  {
    AUTOR __jPt_result=null;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:280^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.AUTOR.BUSCAR(
//        :IDI))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.AUTOR.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"4entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   __sJT_st.setString(2,IDI);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:281^14*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:287^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.AUTOR.BUSCAR(
//        :IDI))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := PUBS.AUTOR.BUSCAR(\n       :2  )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"5entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   __sJT_st.setString(2,IDI);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:288^14*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public AUTORRef getref ()
  throws java.sql.SQLException
  {
    AUTOR __jPt_temp = (AUTOR) this;
    AUTORRef __jPt_result;
 try {
    /*@lineinfo:generated-code*//*@lineinfo:303^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"6entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTORRef)__sJT_st.getORAData(1,entidades.AUTORRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:307^5*/
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    /*@lineinfo:generated-code*//*@lineinfo:313^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"7entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2006,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(2,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(2,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = (entidades.AUTORRef)__sJT_st.getORAData(1,entidades.AUTORRef.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:317^5*/
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
    return __jPt_result;
  }

  public AUTOR guardar ()
  throws java.sql.SQLException
  {
 try {
    AUTOR __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:331^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"8entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:335^5*/
    return __jPt_temp;
 } catch(java.sql.SQLException _err) {
   try {
      getConnectionContext().getExecutionContext().close();
      closeConnection();
      if (__dataSource==null) throw _err;
    AUTOR __jPt_temp = this;
    /*@lineinfo:generated-code*//*@lineinfo:343^5*/

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
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"9entidades.AUTOR",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,2002,"PUBS.AUTOR");
   }
   // set IN parameters
   if (__jPt_temp==null) __sJT_st.setNull(1,2002,"PUBS.AUTOR"); else __sJT_st.setORAData(1,__jPt_temp);
  // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_temp = (entidades.AUTOR)__sJT_st.getORAData(1,entidades.AUTOR.getORADataFactory());
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:347^5*/
    return __jPt_temp;
   } catch (java.sql.SQLException _err2) { 
     try { getConnectionContext().getExecutionContext().close(); } catch (java.sql.SQLException _sqle) {}
     throw _err; 
  }
 }
  }
}/*@lineinfo:generated-code*/