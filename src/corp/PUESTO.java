/*@lineinfo:filename=PUESTO*//*@lineinfo:user-code*//*@lineinfo:1^1*/

package corp;

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

public class PUESTO implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.PUESTO";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

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

    protected static int[] _sqlType = {2, 12, 2, 2};
    protected static ORADataFactory[] _factory = new ORADataFactory[4];
    protected static final PUESTO _PUESTOFactory = new PUESTO();

    public static ORADataFactory getORADataFactory() {
        return _PUESTOFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[4], _sqlType, _factory);
        }
    }

    public PUESTO() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public PUESTO(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public PUESTO(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public PUESTO(java.math.BigDecimal jobId, String jobDesc, java.math.BigDecimal minLvl, java.math.BigDecimal maxLvl) throws SQLException {
        _init_struct(true);
        setJobId(jobId);
        setJobDesc(jobDesc);
        setMinLvl(minLvl);
        setMaxLvl(maxLvl);
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

    public void setFrom(PUESTO o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(PUESTO o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(PUESTO o) {
        _struct = o._struct;
    }

    protected ORAData create(PUESTO o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new PUESTO();
        }
        o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
        o.__onn = ((STRUCT) d).getJavaSqlConnection();
        return o;
    }
    /* accessor methods */

    public java.math.BigDecimal getJobId() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(0);
    }

    public void setJobId(java.math.BigDecimal jobId) throws SQLException {
        _struct.setAttribute(0, jobId);
    }

    public String getJobDesc() throws SQLException {
        return (String) _struct.getAttribute(1);
    }

    public void setJobDesc(String jobDesc) throws SQLException {
        _struct.setAttribute(1, jobDesc);
    }

    public java.math.BigDecimal getMinLvl() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(2);
    }

    public void setMinLvl(java.math.BigDecimal minLvl) throws SQLException {
        _struct.setAttribute(2, minLvl);
    }

    public java.math.BigDecimal getMaxLvl() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(3);
    }

    public void setMaxLvl(java.math.BigDecimal maxLvl) throws SQLException {
        _struct.setAttribute(3, maxLvl);
    }

    public PUESTO borrar()
            throws java.sql.SQLException {
        try {
            PUESTO __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:150^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0corp.PUESTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.PUESTO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:154^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                PUESTO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:162^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1corp.PUESTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.PUESTO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:166^5*/
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

    public PUESTO buscar(
            java.math.BigDecimal IDI)
            throws java.sql.SQLException {
        PUESTO __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:181^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.PUESTO.BUSCAR(
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
                    String theSqlTS = "BEGIN :1 := PUBS.PUESTO.BUSCAR(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2corp.PUESTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                    }
                    // set IN parameters
                    __sJT_st.setBigDecimal(2, IDI);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:182^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:188^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.PUESTO.BUSCAR(
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
                        String theSqlTS = "BEGIN :1 := PUBS.PUESTO.BUSCAR(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3corp.PUESTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                        }
                        // set IN parameters
                        __sJT_st.setBigDecimal(2, IDI);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:189^14*/
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

    public PUESTO guardar()
            throws java.sql.SQLException {
        try {
            PUESTO __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:203^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4corp.PUESTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.PUESTO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:207^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                PUESTO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:215^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5corp.PUESTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.PUESTO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:219^5*/
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

    public PUESTO puesto(
            java.math.BigDecimal JOB_ID,
            String JOB_DESC,
            java.math.BigDecimal MIN_LVL,
            java.math.BigDecimal MAX_LVL,
            PUESTO __jPt_out[])
            throws java.sql.SQLException {
        PUESTO __jPt_temp = (PUESTO) this;
        PUESTO __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:239^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := PUESTO(
//        :JOB_ID,
//        :JOB_DESC,
//        :MIN_LVL,
//        :MAX_LVL);
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
                    String theSqlTS = "BEGIN\n       :1   := PUESTO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6corp.PUESTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                    }
                    // set IN parameters
                    __sJT_st.setBigDecimal(2, JOB_ID);
                    __sJT_st.setString(3, JOB_DESC);
                    __sJT_st.setBigDecimal(4, MIN_LVL);
                    __sJT_st.setBigDecimal(5, MAX_LVL);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:247^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:254^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := PUESTO(
//        :JOB_ID,
//        :JOB_DESC,
//        :MIN_LVL,
//        :MAX_LVL);
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
                        String theSqlTS = "BEGIN\n       :1   := PUESTO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7corp.PUESTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.PUESTO");
                        }
                        // set IN parameters
                        __sJT_st.setBigDecimal(2, JOB_ID);
                        __sJT_st.setString(3, JOB_DESC);
                        __sJT_st.setBigDecimal(4, MIN_LVL);
                        __sJT_st.setBigDecimal(5, MAX_LVL);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (corp.PUESTO) __sJT_st.getORAData(1, corp.PUESTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:262^5*/
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
