package entidades;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ESQ_REGALIARef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PUBS.ESQ_REGALIA";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ESQ_REGALIARef _ESQ_REGALIARefFactory = new ESQ_REGALIARef();

  public static ORADataFactory getORADataFactory()
  { return _ESQ_REGALIARefFactory; }
  /* constructor */
  public ESQ_REGALIARef()
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
    ESQ_REGALIARef r = new ESQ_REGALIARef();
    r._ref = (REF) d;
    return r;
  }

  public static ESQ_REGALIARef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ESQ_REGALIARef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ESQ_REGALIARef: "+exn.toString()); }
  }

  public ESQ_REGALIA getValue() throws SQLException
  {
     return (ESQ_REGALIA) ESQ_REGALIA.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(ESQ_REGALIA c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
