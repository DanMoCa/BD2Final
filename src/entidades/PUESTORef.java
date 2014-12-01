package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class PUESTORef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.PUESTO";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final PUESTORef _PUESTORefFactory = new PUESTORef();

  public static ORADataFactory getORADataFactory()
  { return _PUESTORefFactory; }
  /* constructor */
  public PUESTORef()
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
    PUESTORef r = new PUESTORef();
    r._ref = (REF) d;
    return r;
  }

  public static PUESTORef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (PUESTORef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to PUESTORef: "+exn.toString()); }
  }

  public PUESTO getValue() throws SQLException
  {
     return (PUESTO) PUESTO.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(PUESTO c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
