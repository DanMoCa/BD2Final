/*@lineinfo:filename=EMPLEADO*//*@lineinfo:user-code*//*@lineinfo:1^1*/

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

public class EMPLEADO implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.EMPLEADO";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;
    
    @Override
    public String toString() {
        try {
            return getEmpId();
        } catch (SQLException ex) {
            Logger.getLogger(EMPLEADO.class.getName()).log(Level.SEVERE, null, ex);
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

    protected static int[] _sqlType = {2, 1, 12, 1, 12, 2006, 2, 2006, 91};
    protected static ORADataFactory[] _factory = new ORADataFactory[9];

    static {
        _factory[5] = PUESTORef.getORADataFactory();
        _factory[7] = EDITORIALRef.getORADataFactory();
    }
    protected static final EMPLEADO _EMPLEADOFactory = new EMPLEADO();

    public static ORADataFactory getORADataFactory() {
        return _EMPLEADOFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[9], _sqlType, _factory);
        }
    }

    public EMPLEADO() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public EMPLEADO(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public EMPLEADO(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public EMPLEADO(String empId, String fname, String minit, String lname, PUESTORef refJob, java.math.BigDecimal jobLvl, EDITORIALRef refPub, java.sql.Timestamp hireDate) throws SQLException {
        _init_struct(true);
        setId(null);
        setEmpId(empId);
        setFname(fname);
        setMinit(minit);
        setLname(lname);
        setRefJob(refJob);
        setJobLvl(jobLvl);
        setRefPub(refPub);
        setHireDate(hireDate);
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

    public void setFrom(EMPLEADO o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(EMPLEADO o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(EMPLEADO o) {
        _struct = o._struct;
    }

    protected ORAData create(EMPLEADO o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new EMPLEADO();
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

    public String getEmpId() throws SQLException {
        return (String) _struct.getAttribute(1);
    }

    public void setEmpId(String empId) throws SQLException {
        _struct.setAttribute(1, empId);
    }

    public String getFname() throws SQLException {
        return (String) _struct.getAttribute(2);
    }

    public void setFname(String fname) throws SQLException {
        _struct.setAttribute(2, fname);
    }

    public String getMinit() throws SQLException {
        return (String) _struct.getAttribute(3);
    }

    public void setMinit(String minit) throws SQLException {
        _struct.setAttribute(3, minit);
    }

    public String getLname() throws SQLException {
        return (String) _struct.getAttribute(4);
    }

    public void setLname(String lname) throws SQLException {
        _struct.setAttribute(4, lname);
    }

    public PUESTORef getRefJob() throws SQLException {
        return (PUESTORef) _struct.getAttribute(5);
    }

    public void setRefJob(PUESTORef refJob) throws SQLException {
        _struct.setAttribute(5, refJob);
    }

    public java.math.BigDecimal getJobLvl() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(6);
    }

    public void setJobLvl(java.math.BigDecimal jobLvl) throws SQLException {
        _struct.setAttribute(6, jobLvl);
    }

    public EDITORIALRef getRefPub() throws SQLException {
        return (EDITORIALRef) _struct.getAttribute(7);
    }

    public void setRefPub(EDITORIALRef refPub) throws SQLException {
        _struct.setAttribute(7, refPub);
    }

    public java.sql.Timestamp getHireDate() throws SQLException {
        return (java.sql.Timestamp) _struct.getAttribute(8);
    }

    public void setHireDate(java.sql.Timestamp hireDate) throws SQLException {
        _struct.setAttribute(8, hireDate);
    }

    public EMPLEADO borrar()
            throws java.sql.SQLException {
        try {
            EMPLEADO __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:195^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0entidades.EMPLEADO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.EMPLEADO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:199^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                EMPLEADO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:207^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1entidades.EMPLEADO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.EMPLEADO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:211^5*/
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

    public EMPLEADO buscar(
            String IDI)
            throws java.sql.SQLException {
        EMPLEADO __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:226^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.EMPLEADO.BUSCAR(
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
                    String theSqlTS = "BEGIN :1 := PUBS.EMPLEADO.BUSCAR(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2entidades.EMPLEADO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                    }
                    // set IN parameters
                    __sJT_st.setString(2, IDI);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:227^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:233^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.EMPLEADO.BUSCAR(
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
                        String theSqlTS = "BEGIN :1 := PUBS.EMPLEADO.BUSCAR(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3entidades.EMPLEADO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                        }
                        // set IN parameters
                        __sJT_st.setString(2, IDI);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:234^14*/
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

    public EMPLEADO empleado(
            String EMP_ID,
            String FNAME,
            String MINIT,
            String LNAME,
            PUESTORef REF_JOB,
            java.math.BigDecimal JOB_LVL,
            EDITORIALRef REF_PUB,
            java.sql.Timestamp HIRE_DATE,
            EMPLEADO __jPt_out[])
            throws java.sql.SQLException {
        EMPLEADO __jPt_temp = (EMPLEADO) this;
        EMPLEADO __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:258^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := EMPLEADO(
//        :EMP_ID,
//        :FNAME,
//        :MINIT,
//        :LNAME,
//        :REF_JOB,
//        :JOB_LVL,
//        :REF_PUB,
//        :HIRE_DATE);
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
                    String theSqlTS = "BEGIN\n       :1   := EMPLEADO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  ,\n       :8  ,\n       :9  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4entidades.EMPLEADO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                    }
                    // set IN parameters
                    __sJT_st.setString(2, EMP_ID);
                    __sJT_st.setString(3, FNAME);
                    __sJT_st.setString(4, MINIT);
                    __sJT_st.setString(5, LNAME);
                    if (REF_JOB == null) {
                        __sJT_st.setNull(6, 2006, "PUBS.PUESTO");
                    } else {
                        __sJT_st.setORAData(6, REF_JOB);
                    }
                    __sJT_st.setBigDecimal(7, JOB_LVL);
                    if (REF_PUB == null) {
                        __sJT_st.setNull(8, 2006, "PUBS.EDITORIAL");
                    } else {
                        __sJT_st.setORAData(8, REF_PUB);
                    }
                    __sJT_st.setTimestamp(9, HIRE_DATE);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:270^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:277^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := EMPLEADO(
//        :EMP_ID,
//        :FNAME,
//        :MINIT,
//        :LNAME,
//        :REF_JOB,
//        :JOB_LVL,
//        :REF_PUB,
//        :HIRE_DATE);
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
                        String theSqlTS = "BEGIN\n       :1   := EMPLEADO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  ,\n       :7  ,\n       :8  ,\n       :9  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5entidades.EMPLEADO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                        }
                        // set IN parameters
                        __sJT_st.setString(2, EMP_ID);
                        __sJT_st.setString(3, FNAME);
                        __sJT_st.setString(4, MINIT);
                        __sJT_st.setString(5, LNAME);
                        if (REF_JOB == null) {
                            __sJT_st.setNull(6, 2006, "PUBS.PUESTO");
                        } else {
                            __sJT_st.setORAData(6, REF_JOB);
                        }
                        __sJT_st.setBigDecimal(7, JOB_LVL);
                        if (REF_PUB == null) {
                            __sJT_st.setNull(8, 2006, "PUBS.EDITORIAL");
                        } else {
                            __sJT_st.setORAData(8, REF_PUB);
                        }
                        __sJT_st.setTimestamp(9, HIRE_DATE);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:289^5*/
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

    public EMPLEADORef getref()
            throws java.sql.SQLException {
        EMPLEADO __jPt_temp = (EMPLEADO) this;
        EMPLEADORef __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:305^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6entidades.EMPLEADO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2006, "PUBS.EMPLEADO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.EMPLEADO");
                    } else {
                        __sJT_st.setORAData(2, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.EMPLEADORef) __sJT_st.getORAData(1, entidades.EMPLEADORef.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:309^5*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:315^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7entidades.EMPLEADO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2006, "PUBS.EMPLEADO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.EMPLEADO");
                        } else {
                            __sJT_st.setORAData(2, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.EMPLEADORef) __sJT_st.getORAData(1, entidades.EMPLEADORef.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:319^5*/
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

    public EMPLEADO guardar()
            throws java.sql.SQLException {
        try {
            EMPLEADO __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:333^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "8entidades.EMPLEADO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.EMPLEADO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:337^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                EMPLEADO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:345^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "9entidades.EMPLEADO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.EMPLEADO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.EMPLEADO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.EMPLEADO) __sJT_st.getORAData(1, entidades.EMPLEADO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:349^5*/
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
}/*@lineinfo:generated-code*/
