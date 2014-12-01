/*@lineinfo:filename=TIENDA*//*@lineinfo:user-code*//*@lineinfo:1^1*/

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

public class TIENDA implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.TIENDA";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    @Override
    public String toString() {
        try {
            return getStorId();
        } catch (SQLException ex) {
            Logger.getLogger(TIENDA.class.getName()).log(Level.SEVERE, null, ex);
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

    protected static int[] _sqlType = {2, 1, 12, 12, 12, 1, 1};
    protected static ORADataFactory[] _factory = new ORADataFactory[7];
    protected static final TIENDA _TIENDAFactory = new TIENDA();

    public static ORADataFactory getORADataFactory() {
        return _TIENDAFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[7], _sqlType, _factory);
        }
    }

    public TIENDA() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public TIENDA(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public TIENDA(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public TIENDA(String storId, String storName, String storAddress, String city, String state, String zip) throws SQLException {
        _init_struct(true);
        setId(null);
        setStorId(storId);
        setStorName(storName);
        setStorAddress(storAddress);
        setCity(city);
        setState(state);
        setZip(zip);
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

    public void setFrom(TIENDA o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(TIENDA o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(TIENDA o) {
        _struct = o._struct;
    }

    protected ORAData create(TIENDA o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new TIENDA();
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

    public String getStorId() throws SQLException {
        return (String) _struct.getAttribute(1);
    }

    public void setStorId(String storId) throws SQLException {
        _struct.setAttribute(1, storId);
    }

    public String getStorName() throws SQLException {
        return (String) _struct.getAttribute(2);
    }

    public void setStorName(String storName) throws SQLException {
        _struct.setAttribute(2, storName);
    }

    public String getStorAddress() throws SQLException {
        return (String) _struct.getAttribute(3);
    }

    public void setStorAddress(String storAddress) throws SQLException {
        _struct.setAttribute(3, storAddress);
    }

    public String getCity() throws SQLException {
        return (String) _struct.getAttribute(4);
    }

    public void setCity(String city) throws SQLException {
        _struct.setAttribute(4, city);
    }

    public String getState() throws SQLException {
        return (String) _struct.getAttribute(5);
    }

    public void setState(String state) throws SQLException {
        _struct.setAttribute(5, state);
    }

    public String getZip() throws SQLException {
        return (String) _struct.getAttribute(6);
    }

    public void setZip(String zip) throws SQLException {
        _struct.setAttribute(6, zip);
    }

    public TIENDA borrar()
            throws java.sql.SQLException {
        try {
            TIENDA __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:174^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0entidades.TIENDA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:178^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                TIENDA __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:186^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1entidades.TIENDA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:190^5*/
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

    public TIENDA buscar(
            String IDI)
            throws java.sql.SQLException {
        TIENDA __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:205^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TIENDA.BUSCAR(
//        :IDI))  };
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
                    String theSqlTS = "BEGIN :1 := PUBS.TIENDA.BUSCAR(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2entidades.TIENDA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                    }
                    // set IN parameters
                    __sJT_st.setString(2, IDI);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:206^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:212^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TIENDA.BUSCAR(
//        :IDI))  };
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
                        String theSqlTS = "BEGIN :1 := PUBS.TIENDA.BUSCAR(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3entidades.TIENDA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                        }
                        // set IN parameters
                        __sJT_st.setString(2, IDI);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:213^14*/
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

    public TIENDARef getref()
            throws java.sql.SQLException {
        TIENDA __jPt_temp = (TIENDA) this;
        TIENDARef __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:228^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4entidades.TIENDA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2006, "PUBS.TIENDA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(2, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.TIENDARef) __sJT_st.getORAData(1, entidades.TIENDARef.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:232^5*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:238^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5entidades.TIENDA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2006, "PUBS.TIENDA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(2, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.TIENDARef) __sJT_st.getORAData(1, entidades.TIENDARef.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:242^5*/
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

    public TIENDA guardar()
            throws java.sql.SQLException {
        try {
            TIENDA __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:256^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6entidades.TIENDA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:260^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                TIENDA __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:268^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7entidades.TIENDA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:272^5*/
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

    public TIENDA tienda(
            String STOR_ID,
            String STOR_NAME,
            String STOR_ADDRESS,
            String CITY,
            String STATE,
            String ZIP,
            TIENDA __jPt_out[])
            throws java.sql.SQLException {
        TIENDA __jPt_temp = (TIENDA) this;
        TIENDA __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:294^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := TIENDA(
//        :STOR_ID,
//        :STOR_NAME,
//        :STOR_ADDRESS,
//        :CITY,
//        :STATE,
//        :ZIP);
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
                    String theSqlTS = "BEGIN\n       :1   := TIENDA(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "8entidades.TIENDA", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                    }
                    // set IN parameters
                    __sJT_st.setString(2, STOR_ID);
                    __sJT_st.setString(3, STOR_NAME);
                    __sJT_st.setString(4, STOR_ADDRESS);
                    __sJT_st.setString(5, CITY);
                    __sJT_st.setString(6, STATE);
                    __sJT_st.setString(7, ZIP);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:304^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:311^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := TIENDA(
//        :STOR_ID,
//        :STOR_NAME,
//        :STOR_ADDRESS,
//        :CITY,
//        :STATE,
//        :ZIP);
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
                        String theSqlTS = "BEGIN\n       :1   := TIENDA(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "9entidades.TIENDA", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TIENDA");
                        }
                        // set IN parameters
                        __sJT_st.setString(2, STOR_ID);
                        __sJT_st.setString(3, STOR_NAME);
                        __sJT_st.setString(4, STOR_ADDRESS);
                        __sJT_st.setString(5, CITY);
                        __sJT_st.setString(6, STATE);
                        __sJT_st.setString(7, ZIP);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.TIENDA) __sJT_st.getORAData(1, entidades.TIENDA.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:321^5*/
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
