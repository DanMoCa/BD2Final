package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class DESCUENTORef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.DESCUENTO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final DESCUENTORef _DESCUENTORefFactory = new DESCUENTORef();

  public static ORADataFactory getORADataFactory()
  { return _DESCUENTORefFactory; }
  /* constructor */
  public DESCUENTORef()
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
    DESCUENTORef r = new DESCUENTORef();
    r._ref = (REF) d;
    return r;
  }

  public static DESCUENTORef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (DESCUENTORef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to DESCUENTORef: "+exn.toString()); }
  }

  public DESCUENTO getValue() throws SQLException
  {
     return (DESCUENTO) DESCUENTO.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(DESCUENTO c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
