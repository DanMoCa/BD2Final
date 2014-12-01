/*@lineinfo:filename=DESCUENTO*//*@lineinfo:user-code*//*@lineinfo:1^1*/

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

public class DESCUENTO implements ORAData, ORADataFactory {

    public static final String _SQL_NAME = "PUBS.DESCUENTO";
    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    @Override
    public String toString() {
        try {
            return getDiscounttype();
        } catch (SQLException ex) {
            Logger.getLogger(DESCUENTO.class.getName()).log(Level.SEVERE, null, ex);
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

    protected static int[] _sqlType = {2, 12, 2006, 2, 2, 2};
    protected static ORADataFactory[] _factory = new ORADataFactory[6];

    static {
        _factory[2] = TIENDARef.getORADataFactory();
    }
    protected static final DESCUENTO _DESCUENTOFactory = new DESCUENTO();

    public static ORADataFactory getORADataFactory() {
        return _DESCUENTOFactory;
    }
    /* constructors */

    protected void _init_struct(boolean init) {
        if (init) {
            _struct = new MutableStruct(new Object[6], _sqlType, _factory);
        }
    }

    public DESCUENTO() {
        _init_struct(true);
        __tx = DefaultContext.getDefaultContext();
    }

    public DESCUENTO(DefaultContext c) /*throws SQLException*/ {
        _init_struct(true);
        __tx = c;
    }

    public DESCUENTO(Connection c) /*throws SQLException*/ {
        _init_struct(true);
        __onn = c;
    }

    public DESCUENTO(String discounttype, TIENDARef refStor, java.math.BigDecimal lowqty, java.math.BigDecimal highqty, java.math.BigDecimal discount) throws SQLException {
        _init_struct(true);
        setId(null);
        setDiscounttype(discounttype);
        setRefStor(refStor);
        setLowqty(lowqty);
        setHighqty(highqty);
        setDiscount(discount);
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

    public void setFrom(DESCUENTO o) throws SQLException {
        setContextFrom(o);
        setValueFrom(o);
    }

    protected void setContextFrom(DESCUENTO o) throws SQLException {
        release();
        __tx = o.__tx;
        __onn = o.__onn;
    }

    protected void setValueFrom(DESCUENTO o) {
        _struct = o._struct;
    }

    protected ORAData create(DESCUENTO o, Datum d, int sqlType) throws SQLException {
        if (d == null) {
            if (o != null) {
                o.release();
            };
            return null;
        }
        if (o == null) {
            o = new DESCUENTO();
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

    public String getDiscounttype() throws SQLException {
        return (String) _struct.getAttribute(1);
    }

    public void setDiscounttype(String discounttype) throws SQLException {
        _struct.setAttribute(1, discounttype);
    }

    public TIENDARef getRefStor() throws SQLException {
        return (TIENDARef) _struct.getAttribute(2);
    }

    public void setRefStor(TIENDARef refStor) throws SQLException {
        _struct.setAttribute(2, refStor);
    }

    public java.math.BigDecimal getLowqty() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(3);
    }

    public void setLowqty(java.math.BigDecimal lowqty) throws SQLException {
        _struct.setAttribute(3, lowqty);
    }

    public java.math.BigDecimal getHighqty() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(4);
    }

    public void setHighqty(java.math.BigDecimal highqty) throws SQLException {
        _struct.setAttribute(4, highqty);
    }

    public java.math.BigDecimal getDiscount() throws SQLException {
        return (java.math.BigDecimal) _struct.getAttribute(5);
    }

    public void setDiscount(java.math.BigDecimal discount) throws SQLException {
        _struct.setAttribute(5, discount);
    }

    public DESCUENTO borrar()
            throws java.sql.SQLException {
        try {
            DESCUENTO __jPt_temp = this;
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
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1  .BORRAR();\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "0entidades.DESCUENTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.DESCUENTO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:174^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                DESCUENTO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:182^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "1entidades.DESCUENTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.DESCUENTO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:186^5*/
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

    public java.sql.ResultSet buscardescuentosdetienda(
            TIENDA TIE)
            throws java.sql.SQLException {
        java.sql.ResultSet __jPt_result = null;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:201^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.DESCUENTO.BUSCARDESCUENTOSDETIENDA(
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
                    String theSqlTS = "BEGIN :1 := PUBS.DESCUENTO.BUSCARDESCUENTOSDETIENDA(\n       :2  )  \n; END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "2entidades.DESCUENTO", theSqlTS);
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

            /*@lineinfo:user-code*//*@lineinfo:202^14*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:208^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(PUBS.DESCUENTO.BUSCARDESCUENTOSDETIENDA(
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
                        String theSqlTS = "BEGIN :1 := PUBS.DESCUENTO.BUSCARDESCUENTOSDETIENDA(\n       :2  )  \n; END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "3entidades.DESCUENTO", theSqlTS);
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

                /*@lineinfo:user-code*//*@lineinfo:209^14*/
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

    public DESCUENTO descuento(
            String DISCOUNTTYPE,
            TIENDARef REF_STOR,
            java.math.BigDecimal LOWQTY,
            java.math.BigDecimal HIGHQTY,
            java.math.BigDecimal DISCOUNT,
            DESCUENTO __jPt_out[])
            throws java.sql.SQLException {
        DESCUENTO __jPt_temp = (DESCUENTO) this;
        DESCUENTO __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:230^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := DESCUENTO(
//        :DISCOUNTTYPE,
//        :REF_STOR,
//        :LOWQTY,
//        :HIGHQTY,
//        :DISCOUNT);
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
                    String theSqlTS = "BEGIN\n       :1   := DESCUENTO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  );\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "4entidades.DESCUENTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                    }
                    // set IN parameters
                    __sJT_st.setString(2, DISCOUNTTYPE);
                    if (REF_STOR == null) {
                        __sJT_st.setNull(3, 2006, "PUBS.TIENDA");
                    } else {
                        __sJT_st.setORAData(3, REF_STOR);
                    }
                    __sJT_st.setBigDecimal(4, LOWQTY);
                    __sJT_st.setBigDecimal(5, HIGHQTY);
                    __sJT_st.setBigDecimal(6, DISCOUNT);
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:239^5*/
            __jPt_out[0] = __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:246^5*/

//  ************************************************************
//  #sql [getConnectionContext()] { BEGIN
//        :__jPt_result := DESCUENTO(
//        :DISCOUNTTYPE,
//        :REF_STOR,
//        :LOWQTY,
//        :HIGHQTY,
//        :DISCOUNT);
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
                        String theSqlTS = "BEGIN\n       :1   := DESCUENTO(\n       :2  ,\n       :3  ,\n       :4  ,\n       :5  ,\n       :6  );\n      END;";
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "5entidades.DESCUENTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                        }
                        // set IN parameters
                        __sJT_st.setString(2, DISCOUNTTYPE);
                        if (REF_STOR == null) {
                            __sJT_st.setNull(3, 2006, "PUBS.TIENDA");
                        } else {
                            __sJT_st.setORAData(3, REF_STOR);
                        }
                        __sJT_st.setBigDecimal(4, LOWQTY);
                        __sJT_st.setBigDecimal(5, HIGHQTY);
                        __sJT_st.setBigDecimal(6, DISCOUNT);
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:255^5*/
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

    public DESCUENTORef getref()
            throws java.sql.SQLException {
        DESCUENTO __jPt_temp = (DESCUENTO) this;
        DESCUENTORef __jPt_result;
        try {
            /*@lineinfo:generated-code*//*@lineinfo:271^5*/

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
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "6entidades.DESCUENTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2006, "PUBS.DESCUENTO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(2, 2002, "PUBS.DESCUENTO");
                    } else {
                        __sJT_st.setORAData(2, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_result = (entidades.DESCUENTORef) __sJT_st.getORAData(1, entidades.DESCUENTORef.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:275^5*/
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                /*@lineinfo:generated-code*//*@lineinfo:281^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "7entidades.DESCUENTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2006, "PUBS.DESCUENTO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(2, 2002, "PUBS.DESCUENTO");
                        } else {
                            __sJT_st.setORAData(2, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_result = (entidades.DESCUENTORef) __sJT_st.getORAData(1, entidades.DESCUENTORef.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:285^5*/
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

    public DESCUENTO guardar()
            throws java.sql.SQLException {
        try {
            DESCUENTO __jPt_temp = this;
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
                sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext();
                if (__sJT_cc == null) {
                    sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
                }
                sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext() == null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
                try {
                    String theSqlTS = "BEGIN\n       :1  .GUARDAR();\n      END;";
                    __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "8entidades.DESCUENTO", theSqlTS);
                    if (__sJT_ec.isNew()) {
                        __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                    }
                    // set IN parameters
                    if (__jPt_temp == null) {
                        __sJT_st.setNull(1, 2002, "PUBS.DESCUENTO");
                    } else {
                        __sJT_st.setORAData(1, __jPt_temp);
                    }
                    // execute statement
                    __sJT_ec.oracleExecuteUpdate();
                    // retrieve OUT parameters
                    __jPt_temp = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                } finally {
                    __sJT_ec.oracleClose();
                }
            }

//  ************************************************************

            /*@lineinfo:user-code*//*@lineinfo:303^5*/
            return __jPt_temp;
        } catch (java.sql.SQLException _err) {
            try {
                getConnectionContext().getExecutionContext().close();
                closeConnection();
                if (__dataSource == null) {
                    throw _err;
                }
                DESCUENTO __jPt_temp = this;
                /*@lineinfo:generated-code*//*@lineinfo:311^5*/

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
                        __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc, "9entidades.DESCUENTO", theSqlTS);
                        if (__sJT_ec.isNew()) {
                            __sJT_st.registerOutParameter(1, 2002, "PUBS.DESCUENTO");
                        }
                        // set IN parameters
                        if (__jPt_temp == null) {
                            __sJT_st.setNull(1, 2002, "PUBS.DESCUENTO");
                        } else {
                            __sJT_st.setORAData(1, __jPt_temp);
                        }
                        // execute statement
                        __sJT_ec.oracleExecuteUpdate();
                        // retrieve OUT parameters
                        __jPt_temp = (entidades.DESCUENTO) __sJT_st.getORAData(1, entidades.DESCUENTO.getORADataFactory());
                    } finally {
                        __sJT_ec.oracleClose();
                    }
                }

//  ************************************************************

                /*@lineinfo:user-code*//*@lineinfo:315^5*/
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
