package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AlbumDTO;
import Database.Connection_DB;

public class AlbumDAL {
		private Connection con=null;
		private static AlbumDAL getAlbum=null;
		private AlbumDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			con=Connection_DB.getDb().connect();
		}
		public static AlbumDAL getGetAlbum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			if(getAlbum==null)
			{
				getAlbum=new AlbumDAL();
			}
			return getAlbum;
		}
		public List<AlbumDTO> getAllAlbum() throws Exception
		{
			String urlsql="select maAlbum,tenAlbum from tbAlbum";
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(urlsql);
			List<AlbumDTO> listAlbum=new ArrayList<AlbumDTO>();
			while(rs.next())
			{
				AlbumDTO album=new AlbumDTO(rs.getString(1),rs.getString(2));
				listAlbum.add(album);
			}
		
			return listAlbum;
		}
		
}
