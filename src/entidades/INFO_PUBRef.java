package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class INFO_PUBRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.INFO_PUB";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final INFO_PUBRef _INFO_PUBRefFactory = new INFO_PUBRef();

  public static ORADataFactory getORADataFactory()
  { return _INFO_PUBRefFactory; }
  /* constructor */
  public INFO_PUBRef()
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
    INFO_PUBRef r = new INFO_PUBRef();
    r._ref = (REF) d;
    return r;
  }

  public static INFO_PUBRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (INFO_PUBRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to INFO_PUBRef: "+exn.toString()); }
  }

  public INFO_PUB getValue() throws SQLException
  {
     return (INFO_PUB) INFO_PUB.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(INFO_PUB c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
