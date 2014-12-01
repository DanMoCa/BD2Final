/*@lineinfo:filename=VENTA*//*@lineinfo:user-code*//*@lineinfo:1^1*/

package entidades;

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

public class VENTA implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.VENTA";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    @Override
    public String toString() {
        try {
            return getOrdNum();
        } catch (SQLException ex) {
            Logger.getLogger(VENTA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /* connection management */
    protected Connection __onn = null;
    protected javax.sql.DataSource __dataSource = null;

    public void setDataSource(javax.sql.DataSource dataSource) throws SQLException {
        release();
        __dataSource = dataSource;
    }

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

    public Connection getConnection() throws SQLException {
        if (__onn != null) {
            return __onn;
        } else if (__tx != null) {
            return __tx.getConnection();
        } else if (__dataSource != null) {
            __onn = __dataSource.getConnection();
        }
        return __onn;
    }

    public void release() throws SQLException {
        if (__tx != null && __onn != null) {
            __tx.close(ConnectionContext.KEEP_CONNECTION);
        }
        __onn = null;
        __tx = null;
        __dataSource = null;
    }

    public void closeConnection() {
        if (__dataSource != null) {
            try {
                if (__onn != null) {
                    __onn.close();
                }
            } catch (java.sql.SQLException e) {
            }
            try {
                if (__tx != null) {
                    __tx.close();
                }
            } catch (java.sql.SQLException e) {
            }
            __onn = null;
            __tx = null;
        }
    }
    protected DefaultContext __tx = null;

    public void setConnectionContext(DefaultContext ctx) throws SQLException {
        release();
        __tx = ctx;
    }

    public DefaultContext getConnectionContext() throws SQLException {
        if (__tx == null) {
            __tx = (getConnection() == null) ? DefaultContext.getDefaultContext() : new DefaultContext(getConnection());
        }
        return __tx;
    }
    ;
  protected MutableStruct _struct;

    protected static int[] _sqlType = {2, 2006, 12, 91, 2, 12, 2006};
    protected static ORADataFactory[] _factory = new ORADataFactory[7];

    static {
        _factory[1] = TIENDARef.getORADataFactory();
        _factory[6] = TITULORef.getORADataFactory();
    }
    protected static final VENTA _VENTAFactory = new VENTA();

    public static ORADataFactory getORADataFactory() {
        return _VENTAFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[7], _sqlType, _factory);
        }
    }

    public VENTA() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public VENTA(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public VENTA(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public VENTA(TIENDARef refStore, String ordNum, java.sql.Timestamp ordDate, java.math.BigDecimal qty, String payterms, TITULORef refTitle) throws SQLException {
        _init_struct(true);
        setId(null);
        setRefStore(refStore);
        setOrdNum(ordNum);
        setOrdDate(ordDate);
        setQty(qty);
        setPayterms(payterms);
        setRefTitle(refTitle);
    }

    /* ORAData interface */
    public Datum toDatum(Connection c) throws SQLException {
        if (__tx != null && __onn != c) {
            release();
        }
        __onn = c;
        return _struct.toDatum(c, _SQL_NAME);
    }


    /* ORADataFactory interface */
    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    public void setFrom(VENTA o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(VENTA o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(VENTA o) {
        _struct = o._struct;
    }

    protected ORAData create(VENTA o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new VENTA();
        }
        o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
        o.__onn = ((STRUCT) d).getJavaSqlConnection();
        return o;
    }
    /* accessor methods */

    public java.math.BigDecimal getId() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(0);
    }

    public void setId(java.math.BigDecimal id) throws SQLException {
        _struct.setAttribute(0, id);
    }

    public TIENDARef getRefStore() throws SQLException {
        return (TIENDARef) _struct.getAttribute(1);
    }

    public void setRefStore(TIENDARef refStore) throws SQLException {
        _struct.setAttribute(1, refStore);
    }

    public String getOrdNum() throws SQLException {
        return (String) _struct.getAttribute(2);
    }

    public void setOrdNum(String ordNum) throws SQLException {
        _struct.setAttribute(2, ordNum);
    }

    public java.sql.Timestamp getOrdDate() throws SQLException {
        return (java.sql.Timestamp) _struct.getAttribute(3);
    }

    public void setOrdDate(java.sql.Timestamp ordDate) throws SQLException {
        _struct.setAttribute(3, ordDate);
    }

    public java.math.BigDecimal getQty() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(4);
    }

    public void setQty(java.math.BigDecimal qty) throws SQLException {
        _struct.setAttribute(4, qty);
    }

    public String getPayterms() throws SQLException {
        return (String) _struct.getAttribute(5);
    }

    public void setPayterms(String payterms) throws SQLException {
        _struct.setAttribute(5, payterms);
    }

    public TITULORef getRefTitle() throws SQLException {
        return (TITULORef) _struct.getAttribute(6);
    }

    public void setRefTitle(TITULORef refTitle) throws SQLException {
        _struct.setAttribute(6, refTitle);
    }

    public VENTA borrar()
            throws java.sql.SQLException {
        try {
            VENTA __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:179^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.BORRAR();
//        END;
//       };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1  .BORRAR();\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.VENTA");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:183^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                VENTA __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:191^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.BORRAR();
//        END;
//       };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN\n       :1  .BORRAR();\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.VENTA");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:195^5*/
                return __jPt_temp;
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
    }

    public java.sql.ResultSet findventasdeorden(
            String ORDNUM)
            throws java.sql.SQLException {
        java.sql.ResultSet __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:210^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.VENTA.FINDVENTASDEORDEN(
//        :ORDNUM))  };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN :1 := PUBS.VENTA.FINDVENTASDEORDEN(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    }
                    // set IN parameters
                    __sJT_st.setString(2, ORDNUM);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (java.sql.ResultSet) __sJT_st.getCursor(1);
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:211^17*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:217^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.VENTA.FINDVENTASDEORDEN(
//        :ORDNUM))  };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN :1 := PUBS.VENTA.FINDVENTASDEORDEN(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                        }
                        // set IN parameters
                        __sJT_st.setString(2, ORDNUM);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (java.sql.ResultSet) __sJT_st.getCursor(1);
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:218^17*/
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
        return __jPt_result;
    }

    public java.sql.ResultSet findventasdetienda(
            TIENDA TIE)
            throws java.sql.SQLException {
        java.sql.ResultSet __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:233^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.VENTA.FINDVENTASDETIENDA(
//        :TIE))  };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN :1 := PUBS.VENTA.FINDVENTASDETIENDA(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    }
                    // set IN parameters
                    if (TIE == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(2, TIE);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (java.sql.ResultSet) __sJT_st.getCursor(1);
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:234^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:240^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.VENTA.FINDVENTASDETIENDA(
//        :TIE))  };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN :1 := PUBS.VENTA.FINDVENTASDETIENDA(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                        }
                        // set IN parameters
                        if (TIE == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(2, TIE);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (java.sql.ResultSet) __sJT_st.getCursor(1);
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:241^14*/
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
        return __jPt_result;
    }

    public VENTARef getref()
            throws java.sql.SQLException {
        VENTA __jPt_temp = (VENTA) this;
        VENTARef __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:256^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := :__jPt_temp.GETREF();
//        END;
//       };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1   :=  :2  .GETREF();\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2006, "PUBS.VENTA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.VENTA");
                    } else {
                        __sJT_st.setORAData(2, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.VENTARef) __sJT_st.getORAData(1, entidades.VENTARef.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:260^5*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:266^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := :__jPt_temp.GETREF();
//        END;
//       };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN\n       :1   :=  :2  .GETREF();\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2006, "PUBS.VENTA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.VENTA");
                        } else {
                            __sJT_st.setORAData(2, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.VENTARef) __sJT_st.getORAData(1, entidades.VENTARef.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:270^5*/
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
        return __jPt_result;
    }

    public VENTA guardar()
            throws java.sql.SQLException {
        try {
            VENTA __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:284^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.GUARDAR();
//        END;
//       };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1  .GUARDAR();\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "8entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.VENTA");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:288^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                VENTA __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:296^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_temp.GUARDAR();
//        END;
//       };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN\n       :1  .GUARDAR();\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "9entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.VENTA");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:300^5*/
                return __jPt_temp;
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
    }

    public VENTA venta(
            TIENDARef REF_STORE,
            String ORD_NUM,
            java.sql.Timestamp ORD_DATE,
            java.math.BigDecimal QTY,
            String PAYTERMS,
            TITULORef REF_TITLE,
            VENTA __jPt_out[])
            throws java.sql.SQLException {
        VENTA __jPt_temp = (VENTA) this;
        VENTA __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:322^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := VENTA(
//        :REF_STORE,
//        :ORD_NUM,
//        :ORD_DATE,
//        :QTY,
//        :PAYTERMS,
//        :REF_TITLE);
//        END;
//       };
//  ************************************************************

            {
                // declare temps
                oracle.jdbc.OracleCallableStatement __sJT_st = null;
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1   := VENTA(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "10entidades.VENTA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                    }
                    // set IN parameters
                    if (REF_STORE == null) {
                        __sJT_st.setNull(2, 2006, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(2, REF_STORE);
                    }
                    __sJT_st.setString(3, ORD_NUM);
                    __sJT_st.setTimestamp(4, ORD_DATE);
                    __sJT_st.setBigDecimal(5, QTY);
                    __sJT_st.setString(6, PAYTERMS);
                    if (REF_TITLE == null) {
                        __sJT_st.setNull(7, 2006, "PUBS.TITULO");
                    } else {
                        __sJT_st.setORAData(7, REF_TITLE);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:332^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:339^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := VENTA(
//        :REF_STORE,
//        :ORD_NUM,
//        :ORD_DATE,
//        :QTY,
//        :PAYTERMS,
//        :REF_TITLE);
//        END;
//       };
//  ************************************************************

                {
                    // declare temps
                    oracle.jdbc.OracleCallableStatement __sJT_st = null;
                    sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                    if (__sJT_cc == null) {
                        sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                    }
                    sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                    try {
                        String theSqlTS = "BEGIN\n       :1   := VENTA(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "11entidades.VENTA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.VENTA");
                        }
                        // set IN parameters
                        if (REF_STORE == null) {
                            __sJT_st.setNull(2, 2006, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(2, REF_STORE);
                        }
                        __sJT_st.setString(3, ORD_NUM);
                        __sJT_st.setTimestamp(4, ORD_DATE);
                        __sJT_st.setBigDecimal(5, QTY);
                        __sJT_st.setString(6, PAYTERMS);
                        if (REF_TITLE == null) {
                            __sJT_st.setNull(7, 2006, "PUBS.TITULO");
                        } else {
                            __sJT_st.setORAData(7, REF_TITLE);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.VENTA) __sJT_st.getORAData(1, entidades.VENTA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:349^5*/
                __jPt_out[0] = __jPt_temp;
            } catch (java.sql.SQLException _err2) {
                try {
                    getConnectionContext().getExecutionContext().close();
                } catch (java.sql.SQLException _sqle) {
                }
                throw _err;
            }
        }
        return __jPt_result;
    }
}/*@lineinfo:generated-code*/
