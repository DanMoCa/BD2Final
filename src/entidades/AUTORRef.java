package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class AUTORRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.AUTOR";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final AUTORRef _AUTORRefFactory = new AUTORRef();

  public static ORADataFactory getORADataFactory()
  { return _AUTORRefFactory; }
  /* constructor */
  public AUTORRef()
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
    AUTORRef r = new AUTORRef();
    r._ref = (REF) d;
    return r;
  }

  public static AUTORRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (AUTORRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to AUTORRef: "+exn.toString()); }
  }

  public AUTOR getValue() throws SQLException
  {
     return (AUTOR) AUTOR.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(AUTOR c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
