/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.ArrayList;
import java.util.List;
import mx.enriquez.mysyfu.dao.RazonDAO;
import mx.enriquez.mysyfu.dao.ValoresEstadoDAO;
import mx.enriquez.mysyfu.model.Razon;
import mx.enriquez.mysyfu.model.Valores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ISC. Cristian Enríquez
 */
@Service
public class RazonServiceImpl implements RazonService {

    @Autowired
    private RazonDAO razonDAO;

    //@Autowired
    private ValoresEstadoDAO valoresDAO;

    public void setRazonDAO(RazonDAO razonDAO) {
        this.razonDAO = razonDAO;
    }
    
    public void setValoresDAO(ValoresEstadoDAO valoresDAO) {
        this.valoresDAO = valoresDAO;
    }

    @Override
    @Transactional
    public void addRazon(Razon r) {
        this.razonDAO.addRazon(r);
    }

    @Override
    @Transactional
    public void updateRazon(Razon r) {
        this.razonDAO.updateRazon(r);
    }

    @Override
    @Transactional
    public List<Razon> listRazones() {
        return this.razonDAO.listRazones();
    }

    @Override
    @Transactional
    public Razon getRazonById(int id) {
        return this.razonDAO.getRazonById(id);
    }

    @Override
    @Transactional
    public void removeRazon(int id) {
        this.razonDAO.removeRazon(id);
    }

    //Calculo de razones de rotacion
    @Override
    @Transactional
    public ArrayList listaRazonesRotacion(int id) {
        ArrayList listRazonesRotacion = new ArrayList();
        
        //Para testear
        Valores valoresEstado =  new Valores();
        valoresEstado.setId(1);
        valoresEstado.setIdEstado(1);
        valoresEstado.setca(3441000);
        valoresEstado.setcc(0);
        valoresEstado.setcl(6004000);
        valoresEstado.setcm(0);
        valoresEstado.setddc(469000);
        valoresEstado.setef(935000);
        valoresEstado.setntsls(0);
        valoresEstado.setra(961000);
        valoresEstado.setracp(0);
        valoresEstado.setrp(935000);
        valoresEstado.setta(7859000);
        valoresEstado.setNca(4418000);
        valoresEstado.setWrkcp(0);
        valoresEstado.setInvt(86000);
        valoresEstado.setTl(6924000);
        
        //Para produccion
        //valoresEstado =  this.valoresDAO.getValorEstadoById(id);
        
        //Rotacion del activo total
        Razon totalAssets = new Razon();
        totalAssets.setIdestadof(id);
        totalAssets.setnRazon("Rotacion del activo total");
        totalAssets.setValor(this.ToTotalAssets(valoresEstado.getntsls(), valoresEstado.getta()));
        listRazonesRotacion.add(totalAssets);
        
        //Rotacion del activo no corriente
        Razon nonCurrentAssets = new Razon();
        nonCurrentAssets.setIdestadof(id);
        nonCurrentAssets.setnRazon("Rotacion del activo no corriente");
        nonCurrentAssets.setValor(this.ToNonCurrentAssets(valoresEstado.getntsls(), valoresEstado.getNca()));
        listRazonesRotacion.add(nonCurrentAssets);
        
        //Rotacion del activo corriente
        Razon currentAssetsTurnOver  = new Razon();
        currentAssetsTurnOver.setIdestadof(id);
        currentAssetsTurnOver.setnRazon("Rotacion del activo corriente");
        currentAssetsTurnOver.setValor(this.ToCurrentAssets(valoresEstado.getntsls(), valoresEstado.getca()));
        listRazonesRotacion.add(currentAssetsTurnOver);
        
        //Rotacion de los clientes
        Razon turnOverCustomers = new Razon();
        turnOverCustomers.setIdestadof(id);
        turnOverCustomers.setnRazon("Rotacion de los clientes");
        turnOverCustomers.setValor(this.ToCustomers(valoresEstado.getntsls(), valoresEstado.getddc()));
        listRazonesRotacion.add(turnOverCustomers);
        
        //Rotacion de almacen
        Razon stockRotation = new Razon();
        stockRotation.setIdestadof(id);
        stockRotation.setnRazon("Rotacion de almacen");
        stockRotation.setValor(this.ToStockRotation(valoresEstado.getntsls(), valoresEstado.getInvt()));
        listRazonesRotacion.add(stockRotation);
        
        //Rotacion del capital circulante
        Razon capitalTurnover = new Razon();
        capitalTurnover.setIdestadof(id);
        capitalTurnover.setnRazon("Rotacion del capital circulante");
        capitalTurnover.setValor(this.ToCapital(valoresEstado.getntsls(), valoresEstado.getWrkcp()));
        listRazonesRotacion.add(capitalTurnover);
        
        return listRazonesRotacion;
    }
    
    //Calculo de razones de liquidez
    @Override
    @Transactional
    public ArrayList listaRazonesLiquidez(int id) {
        ArrayList listRazonesLiquidez = new ArrayList();
        
        //Para testear
        Valores valoresEstado =  new Valores();
        valoresEstado.setId(1);
        valoresEstado.setIdEstado(1);
        valoresEstado.setca(3441000);
        valoresEstado.setcc(0);
        valoresEstado.setcl(6004000);
        valoresEstado.setcm(0);
        valoresEstado.setddc(469000);
        valoresEstado.setef(935000);
        valoresEstado.setntsls(0);
        valoresEstado.setra(961000);
        valoresEstado.setracp(0);
        valoresEstado.setrp(935000);
        valoresEstado.setta(7859000);
        valoresEstado.setNca(4418000);
        valoresEstado.setWrkcp(0);
        valoresEstado.setInvt(86000);
        valoresEstado.setTl(6924000);
        
        //Para produccion
        //Valores valoresEstado =  this.ValoresDAO.getValorEstadoById(id);
        
        //Capital de trabajo
        Razon workingCapital = new Razon();
        workingCapital.setIdestadof(id);
        workingCapital.setnRazon("Capital de trabajo");
        workingCapital.setValor(this.LrWorkingCapital(valoresEstado.getca(), valoresEstado.getcl()));
        listRazonesLiquidez.add(workingCapital);
        
        //Capital de trabajo neto sobre total de activos
        Razon netWorkingCapitalOverTA = new Razon();
        netWorkingCapitalOverTA.setIdestadof(id);
        netWorkingCapitalOverTA.setnRazon("Capital de trabajo sobre Total de activos");
        netWorkingCapitalOverTA.setValor(this.LrNetWorkingOverTotalAssets(valoresEstado.getca(), valoresEstado.getcl(), valoresEstado.getta()));
        listRazonesLiquidez.add(netWorkingCapitalOverTA);
        
        //Capital de trabajo neto sobre deudas a corto plazo
        Razon netWorkinCapitalOnShortTermDeb = new Razon();
        netWorkinCapitalOnShortTermDeb.setIdestadof(id);
        netWorkinCapitalOnShortTermDeb.setnRazon("Capital de trabajo sobre deudas a corto plazo");
        netWorkinCapitalOnShortTermDeb.setValor(this.LrNetWorkingOnShort(valoresEstado.getca(), valoresEstado.getcl()));
        listRazonesLiquidez.add(netWorkinCapitalOnShortTermDeb);
        
        //Test ACIDO
        Razon acidTest = new Razon();
        acidTest.setIdestadof(id);
        acidTest.setnRazon("Test Acido");
        acidTest.setValor(this.LrAcidTest(valoresEstado.getca(), valoresEstado.getInvt(), valoresEstado.getcl()));
        listRazonesLiquidez.add(acidTest);
        
        //Dias de medicion del intervalo de tiempo
        Razon dayTimeInterval = new Razon();
        dayTimeInterval.setIdestadof(id);
        dayTimeInterval.setnRazon("Medicion del intervalo de tiempo");
        dayTimeInterval.setValor(this.LrDaytimeIntervalMeasurement(valoresEstado.getca(), valoresEstado.getcm()));
        listRazonesLiquidez.add(dayTimeInterval);
        
        //Razon corriente
        Razon currentRatio = new Razon();
        currentRatio.setIdestadof(id);
        currentRatio.setnRazon("Razon corriente");
        currentRatio.setValor(this.LrCurrentRatio(valoresEstado.getca(), valoresEstado.getcl()));
        listRazonesLiquidez.add(currentRatio);
        
        //Razon de efectivo
        Razon cashRatio = new Razon();
        cashRatio.setIdestadof(id);
        cashRatio.setnRazon("Razon de efectivo");
        cashRatio.setValor(this.LrCashRatio(valoresEstado.getef(), valoresEstado.getcl()));
        listRazonesLiquidez.add(cashRatio);
        
        return listRazonesLiquidez;
    }
    
    //Calculo de razones de solvencia
    @Override
    @Transactional
    public ArrayList listaRazonesSolvencia(int id) {
        ArrayList listRazonesSolvencia = new ArrayList();
        
        //Para testear
        Valores valoresEstado =  new Valores();
        valoresEstado.setId(1);
        valoresEstado.setIdEstado(1);
        valoresEstado.setca(3441000);
        valoresEstado.setcc(0);
        valoresEstado.setcl(6004000);
        valoresEstado.setcm(0);
        valoresEstado.setddc(469000);
        valoresEstado.setef(935000);
        valoresEstado.setntsls(0);
        valoresEstado.setra(961000);
        valoresEstado.setracp(0);
        valoresEstado.setrp(935000);
        valoresEstado.setta(7859000);
        valoresEstado.setNca(4418000);
        valoresEstado.setWrkcp(0);
        valoresEstado.setInvt(86000);
        valoresEstado.setTl(6924000);
        
        //Para produccion
        //Valores valoresEstado =  this.ValoresDAO.getValorEstadoById(id);
        
        //Coeficiente de endeudamiento
        Razon debtToEquity = new Razon();
        debtToEquity.setIdestadof(id);
        debtToEquity.setnRazon("Coeficiente de endeudamiento");
        debtToEquity.setValor(this.SrDebtToEquity(valoresEstado.getra(), valoresEstado.getrp()));
        listRazonesSolvencia.add(debtToEquity);
        
        //Calidad de la deuda
        Razon debtQuality = new Razon();
        debtQuality.setIdestadof(id);
        debtQuality.setnRazon("Calidad de la deuda");
        debtQuality.setValor(this.SrDebtQuality(valoresEstado.getracp(), valoresEstado.getra()));
        listRazonesSolvencia.add(debtQuality);
        
        //Razon de deuda
        Razon debtRatio = new Razon();
        debtRatio.setIdestadof(id);
        debtRatio.setnRazon("Razon de deuda");
        debtRatio.setValor(this.SrDebtRatio(valoresEstado.getTl(), valoresEstado.getta()));
        listRazonesSolvencia.add(debtRatio);
        
        return listRazonesSolvencia;
    }
    
    /*FORMULAS PARA EL CÁLCULO DE RAZONES DE ROTACION (To)*/
    public double ToTotalAssets(double netSales, double totalAssets) {
        return netSales / totalAssets;
    }

    public double ToNonCurrentAssets(double netSales, double nonCurrentAssets) {
        return netSales / nonCurrentAssets;
    }

    public double ToCurrentAssets(double netSales, double currentAssets) {
        return netSales / currentAssets;
    }

    public double ToCustomers(double netSales, double ddc) {
        return netSales / ddc;
    }

    public double ToStockRotation(double netSales, double inventory) {
        return netSales / inventory;
    }

    public double ToCapital(double netSales, double wc) {
        return netSales / wc;
    }

    /*CÁLCULO DE RATIOS DE LIQUIDEZ (Lr)*/
    public double LrWorkingCapital(double currentAssets, double currentLiabilities) {
        return currentAssets - currentLiabilities;
    }

    public double LrNetWorkingOverTotalAssets(double currentAssets, double currentLiabilities, double totalAssets) {
        return (currentAssets - currentLiabilities) / totalAssets;
    }
    
    public double LrNetWorkingOnShort(double currentAssets, double currentLiabilities) {
        return (currentAssets - currentLiabilities) / currentLiabilities;
    }

    public double LrAcidTest(double currentAssets, double inventory, double currentLiabilities) {
        return (currentAssets - inventory) / currentLiabilities;
    }

    public double LrDaytimeIntervalMeasurement(double currentAssets, double costOfMaterials) {
        return (currentAssets - costOfMaterials) * 365;
    }

    public double LrCurrentRatio(double currentAssets, double currentLiabilities) {
        return currentAssets / currentLiabilities;
    }

    public double LrCashRatio(double cash, double currentLiabilities) {
        return cash / currentLiabilities;
    }

    /*CÁLCULO DE RATIOS DE SOLVENCIA (Sr)*/
    public double SrDebtToEquity(double borrowings, double equity) {
        return borrowings / equity;
    }

    public double SrDebtQuality(double stBorrowings, double borrowings) {
        return stBorrowings / borrowings;
    }

    public double SrDebtRatio(double totalLiabilities, double totalAssets) {
        return (totalLiabilities / totalAssets) * 100;
    }

}
