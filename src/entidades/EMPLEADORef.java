package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class EMPLEADORef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.EMPLEADO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final EMPLEADORef _EMPLEADORefFactory = new EMPLEADORef();

  public static ORADataFactory getORADataFactory()
  { return _EMPLEADORefFactory; }
  /* constructor */
  public EMPLEADORef()
  {
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _ref;
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    EMPLEADORef r = new EMPLEADORef();
    r._ref = (REF) d;
    return r;
  }

  public static EMPLEADORef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (EMPLEADORef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to EMPLEADORef: "+exn.toString()); }
  }

  public EMPLEADO getValue() throws SQLException
  {
     return (EMPLEADO) EMPLEADO.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(EMPLEADO c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
