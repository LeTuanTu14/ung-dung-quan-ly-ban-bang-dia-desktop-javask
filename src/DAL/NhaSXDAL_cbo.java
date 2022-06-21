package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.NhaSXDTO_cbo;
import Database.Connection_DB;

public class NhaSXDAL_cbo {
			private Connection con=null;
			private static NhaSXDAL_cbo getNSX_CBO=null;
			private NhaSXDAL_cbo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
			{
				con=Connection_DB.getDb().connect();
			}
			public static NhaSXDAL_cbo getGetNSX_CBO() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
				if(getNSX_CBO==null)
				{
					getNSX_CBO=new NhaSXDAL_cbo();
				}
				return getNSX_CBO;
			}
			public List<NhaSXDTO_cbo> getAllNhaSX() throws Exception
			{
					String sql="select maNSX,tenNSX  from  tbNhaSX";
					Statement state=con.createStatement();
					ResultSet rs=state.executeQuery(sql);
					List<NhaSXDTO_cbo> listNSX=new ArrayList<NhaSXDTO_cbo>();
					while(rs.next())
					{
						NhaSXDTO_cbo nsx=new NhaSXDTO_cbo(rs.getString(1), rs.getString(2));
						listNSX.add(nsx);
					}
				
					return listNSX;
			}
			
}
