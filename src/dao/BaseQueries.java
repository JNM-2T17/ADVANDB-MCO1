package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import model.AvgDeathAge;
import model.AvgOFWsPerNuclearFamily;
import model.CatchRatio;
import model.CommonBeneficiary;
import model.CropVolume;
import model.FishCount;
import model.HealthyKids;

public class BaseQueries {
	public static Collection<AvgOFWsPerNuclearFamily> getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(int val){
		ArrayList<AvgOFWsPerNuclearFamily> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
							"SELECT mun, zone, brgy, purok"
							+ ", SUM(nnucfam) AS `Nuclear Families`, SUM(nofw) AS OFWs"
							+ ", SUM(nofw) / SUM(nnucfam) AS `Average OFW's per Nuclear Family`"
							+ " FROM db_hpq.hpq_hh"
							+ " WHERE nnucfam > 0"
							+ " GROUP BY mun, zone, brgy, purok"
							+ " HAVING SUM(nofw) > ?");
			statement.setInt(1, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				AvgOFWsPerNuclearFamily res = new AvgOFWsPerNuclearFamily(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getInt(5), 
						resultSet.getInt(6), 
						resultSet.getDouble(7));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<HealthyKids> getPlacesWithHealthyKidsGreaterThan(int val, int minNutIndex){
		ArrayList<HealthyKids> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount"
							+ " FROM hpq_mem"
							+ " WHERE mnutind <= ?"
							+ " GROUP BY country_resid, prov_resid_code,mnutind"
							+ " HAVING nutCount > ?");
			statement.setInt(1, minNutIndex);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				HealthyKids res = new HealthyKids(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getInt(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<AvgDeathAge> getAvgDeathAgeGreaterThan(int val, int deady){
		ArrayList<AvgDeathAge> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age"
							+ " FROM hpq_hh H, hpq_death D"
							+ " WHERE H.id = D.hpq_hh_id AND mdeady = ?"
							+ " GROUP BY H.mun,H.zone,H.brgy,mdeadsx"
							+ " HAVING AVG(mdeadage) > ?");
			statement.setInt(1, deady);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				AvgDeathAge res = new AvgDeathAge(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getDouble(5));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<FishCount> getFishCountsGreaterThan(int val, int aquanitype){
		ArrayList<FishCount> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy, SUM(aquani_vol) fishcount"
							+ " FROM hpq_hh H, hpq_aquani A"
							+ " WHERE H.id = A.hpq_hh_id AND aquanitype = ?"
							+ " GROUP BY H.mun,H.zone,H.brgy"
							+ " HAVING COUNT(H.id) > ?");
			statement.setInt(1, aquanitype);
			statement.setInt(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				FishCount res = new FishCount(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CropVolume> getCropVolumesGreaterThan(double val,int croptype){
		ArrayList<CropVolume> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop, SUM(alp_area) AS totalArea, SUM(crop_vol)/SUM(alp_area) AS cropDensity"
							+ " FROM hpq_hh H, hpq_alp A, hpq_crop C"
							+ " WHERE H.id = A.hpq_hh_id AND H.id = C.hpq_hh_id"
							+ " AND croptype = ?"
							+ " GROUP BY H.mun,H.zone,H.brgy"
							+ " HAVING cropDensity > ?");
			statement.setDouble(1, croptype);
			statement.setDouble(2, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CropVolume res = new CropVolume(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getInt(5), 
						resultSet.getDouble(6));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CatchRatio> getCatchRatiosGreaterThan(double val, int aquaequiptype, int aquanitype){
		ArrayList<CatchRatio> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"select mun, zone, brgy, SUM(aquaequip_line) AS totalequip, SUM(aquani_vol) AS totalvol, SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip "
							+ " from hpq_aquaequip aa, hpq_aquani ap, hpq_hh h"
							+ " where h.id = aa.hpq_hh_id && h.id = ap.hpq_hh_id AND aquaequiptype = ?"
							+ " AND aquanitype = ?"
							+ " group by H.mun,H.zone,H.brgy"
							+ " HAVING CatchPerEquip > ?");
			statement.setInt(1, aquaequiptype);
			statement.setInt(2, aquanitype);
			statement.setDouble(3, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CatchRatio res = new CatchRatio(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getLong(4), 
						resultSet.getLong(5), 
						resultSet.getDouble(6));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static Collection<CommonBeneficiary> getCommonBeneficiariesGreaterThan(int val){
		ArrayList<CommonBeneficiary> list = new ArrayList<>();
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(
					"SELECT H.mun,H.zone,H.brgy,COUNT(H.id) benefCount"
							+ " FROM hpq_hh H, hpq_phiheal_spon_mem PSM, hpq_phiheal_empl_mem PEM"
							+ " ,hpq_phiheal_indiv_mem PIM, hpq_phiheal_life_mem PLM"
							+ " WHERE H.id = PSM.hpq_hh_id AND H.id = PEM.hpq_hh_id AND H.id = PIM.hpq_hh_id "
							+ " AND H.id = PLM.hpq_hh_id"
							+ " AND PSM.phiheal_spon_mem_refno = PEM.phiheal_empl_mem_refno"
							+ " AND PEM.phiheal_empl_mem_refno = PIM.phiheal_indiv_mem_refno "
							+ " AND PIM.phiheal_indiv_mem_refno = PLM.phiheal_life_mem_refno "
							+ " GROUP BY H.mun,H.zone,H.brgy"
							+ " HAVING benefCount > ?");
			statement.setInt(1, val);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CommonBeneficiary res = new CommonBeneficiary(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4));
				list.add(res);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
