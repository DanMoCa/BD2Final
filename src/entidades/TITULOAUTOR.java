/*@lineinfo:filename=TITULOAUTOR*//*@lineinfo:user-code*//*@lineinfo:1^1*/

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

public class TITULOAUTOR implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.TITULOAUTOR";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    @Override
    public String toString() {
        try {
            return getAuOrd() + "";
        } catch (SQLException ex) {
            Logger.getLogger(TITULOAUTOR.class.getName()).log(Level.SEVERE, null, ex);
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

    protected static int[] _sqlType = {2, 2006, 2006, 2, 2};
    protected static ORADataFactory[] _factory = new ORADataFactory[5];

    static {
        _factory[1] = AUTORRef.getORADataFactory();
        _factory[2] = TITULORef.getORADataFactory();
    }
    protected static final TITULOAUTOR _TITULOAUTORFactory = new TITULOAUTOR();

    public static ORADataFactory getORADataFactory() {
        return _TITULOAUTORFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[5], _sqlType, _factory);
        }
    }

    public TITULOAUTOR() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public TITULOAUTOR(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public TITULOAUTOR(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public TITULOAUTOR(AUTORRef refAuthor, TITULORef refTitle, java.math.BigDecimal auOrd, java.math.BigDecimal royaltyper) throws SQLException {
        _init_struct(true);
        setId(null);
        setRefAuthor(refAuthor);
        setRefTitle(refTitle);
        setAuOrd(auOrd);
        setRoyaltyper(royaltyper);
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

    public void setFrom(TITULOAUTOR o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(TITULOAUTOR o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(TITULOAUTOR o) {
        _struct = o._struct;
    }

    protected ORAData create(TITULOAUTOR o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new TITULOAUTOR();
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

    public AUTORRef getRefAuthor() throws SQLException {
        return (AUTORRef) _struct.getAttribute(1);
    }

    public void setRefAuthor(AUTORRef refAuthor) throws SQLException {
        _struct.setAttribute(1, refAuthor);
    }

    public TITULORef getRefTitle() throws SQLException {
        return (TITULORef) _struct.getAttribute(2);
    }

    public void setRefTitle(TITULORef refTitle) throws SQLException {
        _struct.setAttribute(2, refTitle);
    }

    public java.math.BigDecimal getAuOrd() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(3);
    }

    public void setAuOrd(java.math.BigDecimal auOrd) throws SQLException {
        _struct.setAttribute(3, auOrd);
    }

    public java.math.BigDecimal getRoyaltyper() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(4);
    }

    public void setRoyaltyper(java.math.BigDecimal royaltyper) throws SQLException {
        _struct.setAttribute(4, royaltyper);
    }

    public TITULOAUTOR borrar()
            throws java.sql.SQLException {
        try {
            TITULOAUTOR __jPt_temp = this;
            /*@lineinfo:generated-code*//*@lineinfo:163^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.TITULOAUTOR");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:167^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                TITULOAUTOR __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:175^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.TITULOAUTOR");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:179^5*/
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

    public java.sql.ResultSet buscarautoresdetitulo(
            TITULO TIT)
            throws java.sql.SQLException {
        java.sql.ResultSet __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:194^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TITULOAUTOR.BUSCARAUTORESDETITULO(
//        :TIT))  };
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
                    String theSqlTS = "BEGIN :1 := PUBS.TITULOAUTOR.BUSCARAUTORESDETITULO(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    }
                    // set IN parameters
                    if (TIT == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.TITULO");
                    } else {
                        __sJT_st.setORAData(2, TIT);
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

            /*@lineinfo:user-code*//*@lineinfo:195^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:201^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TITULOAUTOR.BUSCARAUTORESDETITULO(
//        :TIT))  };
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
                        String theSqlTS = "BEGIN :1 := PUBS.TITULOAUTOR.BUSCARAUTORESDETITULO(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                        }
                        // set IN parameters
                        if (TIT == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.TITULO");
                        } else {
                            __sJT_st.setORAData(2, TIT);
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

                /*@lineinfo:user-code*//*@lineinfo:202^14*/
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

    public java.sql.ResultSet buscartitulosdeautor(
            AUTOR AUT)
            throws java.sql.SQLException {
        java.sql.ResultSet __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:217^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TITULOAUTOR.BUSCARTITULOSDEAUTOR(
//        :AUT))  };
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
                    String theSqlTS = "BEGIN :1 := PUBS.TITULOAUTOR.BUSCARTITULOSDEAUTOR(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    }
                    // set IN parameters
                    if (AUT == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.AUTOR");
                    } else {
                        __sJT_st.setORAData(2, AUT);
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

            /*@lineinfo:user-code*//*@lineinfo:218^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:224^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.TITULOAUTOR.BUSCARTITULOSDEAUTOR(
//        :AUT))  };
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
                        String theSqlTS = "BEGIN :1 := PUBS.TITULOAUTOR.BUSCARTITULOSDEAUTOR(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                        }
                        // set IN parameters
                        if (AUT == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.AUTOR");
                        } else {
                            __sJT_st.setORAData(2, AUT);
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

                /*@lineinfo:user-code*//*@lineinfo:225^14*/
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

    public TITULOAUTORRef getref()
            throws java.sql.SQLException {
        TITULOAUTOR __jPt_temp = (TITULOAUTOR) this;
        TITULOAUTORRef __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:240^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2006, "PUBS.TITULOAUTOR");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.TITULOAUTOR");
                    } else {
                        __sJT_st.setORAData(2, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.TITULOAUTORRef) __sJT_st.getORAData(1, entidades.TITULOAUTORRef.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:244^5*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:250^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2006, "PUBS.TITULOAUTOR");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.TITULOAUTOR");
                        } else {
                            __sJT_st.setORAData(2, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.TITULOAUTORRef) __sJT_st.getORAData(1, entidades.TITULOAUTORRef.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:254^5*/
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

    public TITULOAUTOR guardar()
            throws java.sql.SQLException {
        try {
            TITULOAUTOR __jPt_temp = this;
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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "8entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.TITULOAUTOR");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:272^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                TITULOAUTOR __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:280^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "9entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.TITULOAUTOR");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:284^5*/
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

    public TITULOAUTOR tituloautor(
            AUTORRef REF_AUTHOR,
            TITULORef REF_TITLE,
            java.math.BigDecimal AU_ORD,
            java.math.BigDecimal ROYALTYPER,
            TITULOAUTOR __jPt_out[])
            throws java.sql.SQLException {
        TITULOAUTOR __jPt_temp = (TITULOAUTOR) this;
        TITULOAUTOR __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:304^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := TITULOAUTOR(
//        :REF_AUTHOR,
//        :REF_TITLE,
//        :AU_ORD,
//        :ROYALTYPER);
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
                    String theSqlTS = "BEGIN\n       :1   := TITULOAUTOR(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "10entidades.TITULOAUTOR", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                    }
                    // set IN parameters
                    if (REF_AUTHOR == null) {
                        __sJT_st.setNull(2, 2006, "PUBS.AUTOR");
                    } else {
                        __sJT_st.setORAData(2, REF_AUTHOR);
                    }
                    if (REF_TITLE == null) {
                        __sJT_st.setNull(3, 2006, "PUBS.TITULO");
                    } else {
                        __sJT_st.setORAData(3, REF_TITLE);
                    }
                    __sJT_st.setBigDecimal(4, AU_ORD);
                    __sJT_st.setBigDecimal(5, ROYALTYPER);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:312^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:319^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := TITULOAUTOR(
//        :REF_AUTHOR,
//        :REF_TITLE,
//        :AU_ORD,
//        :ROYALTYPER);
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
                        String theSqlTS = "BEGIN\n       :1   := TITULOAUTOR(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "11entidades.TITULOAUTOR", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.TITULOAUTOR");
                        }
                        // set IN parameters
                        if (REF_AUTHOR == null) {
                            __sJT_st.setNull(2, 2006, "PUBS.AUTOR");
                        } else {
                            __sJT_st.setORAData(2, REF_AUTHOR);
                        }
                        if (REF_TITLE == null) {
                            __sJT_st.setNull(3, 2006, "PUBS.TITULO");
                        } else {
                            __sJT_st.setORAData(3, REF_TITLE);
                        }
                        __sJT_st.setBigDecimal(4, AU_ORD);
                        __sJT_st.setBigDecimal(5, ROYALTYPER);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.TITULOAUTOR) __sJT_st.getORAData(1, entidades.TITULOAUTOR.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:327^5*/
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
