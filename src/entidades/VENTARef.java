package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class VENTARef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.VENTA";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final VENTARef _VENTARefFactory = new VENTARef();

  public static ORADataFactory getORADataFactory()
  { return _VENTARefFactory; }
  /* constructor */
  public VENTARef()
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
    VENTARef r = new VENTARef();
    r._ref = (REF) d;
    return r;
  }

  public static VENTARef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (VENTARef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to VENTARef: "+exn.toString()); }
  }

  public VENTA getValue() throws SQLException
  {
     return (VENTA) VENTA.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(VENTA c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
