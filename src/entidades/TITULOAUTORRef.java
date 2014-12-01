package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class TITULOAUTORRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.TITULOAUTOR";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final TITULOAUTORRef _TITULOAUTORRefFactory = new TITULOAUTORRef();

  public static ORADataFactory getORADataFactory()
  { return _TITULOAUTORRefFactory; }
  /* constructor */
  public TITULOAUTORRef()
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
    TITULOAUTORRef r = new TITULOAUTORRef();
    r._ref = (REF) d;
    return r;
  }

  public static TITULOAUTORRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (TITULOAUTORRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to TITULOAUTORRef: "+exn.toString()); }
  }

  public TITULOAUTOR getValue() throws SQLException
  {
     return (TITULOAUTOR) TITULOAUTOR.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(TITULOAUTOR c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
