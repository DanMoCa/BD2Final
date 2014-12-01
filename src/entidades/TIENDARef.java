package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class TIENDARef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.TIENDA";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final TIENDARef _TIENDARefFactory = new TIENDARef();

  public static ORADataFactory getORADataFactory()
  { return _TIENDARefFactory; }
  /* constructor */
  public TIENDARef()
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
    TIENDARef r = new TIENDARef();
    r._ref = (REF) d;
    return r;
  }

  public static TIENDARef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (TIENDARef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to TIENDARef: "+exn.toString()); }
  }

  public TIENDA getValue() throws SQLException
  {
     return (TIENDA) TIENDA.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(TIENDA c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
