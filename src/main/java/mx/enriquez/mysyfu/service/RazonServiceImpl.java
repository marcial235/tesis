/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.enriquez.mysyfu.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
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
    public ArrayList listaRazonesRotacion(Valores v) {
        ArrayList listRazonesRotacion = new ArrayList();
        
        //Rotacion del activo total
        Razon totalAssets = new Razon();
        totalAssets.setIdestadof(v.getId());
        totalAssets.setnRazon("Rotacion del activo total");
        totalAssets.setValor(this.ToTotalAssets(v.getntsls(), v.getta()));
        listRazonesRotacion.add(totalAssets);
        
        //Rotacion del activo no corriente
        Razon nonCurrentAssets = new Razon();
        nonCurrentAssets.setIdestadof(v.getId());
        nonCurrentAssets.setnRazon("Rotacion del activo no corriente");
        nonCurrentAssets.setValor(this.ToNonCurrentAssets(v.getntsls(), v.getNca()));
        listRazonesRotacion.add(nonCurrentAssets);
        
        //Rotacion del activo corriente
        Razon currentAssetsTurnOver  = new Razon();
        currentAssetsTurnOver.setIdestadof(v.getId());
        currentAssetsTurnOver.setnRazon("Rotacion del activo corriente");
        currentAssetsTurnOver.setValor(this.ToCurrentAssets(v.getntsls(), v.getca()));
        listRazonesRotacion.add(currentAssetsTurnOver);
        
        //Rotacion de los clientes
        Razon turnOverCustomers = new Razon();
        turnOverCustomers.setIdestadof(v.getId());
        turnOverCustomers.setnRazon("Rotacion de los clientes");
        turnOverCustomers.setValor(this.ToCustomers(v.getntsls(), v.getddc()));
        listRazonesRotacion.add(turnOverCustomers);
        
        //Rotacion de almacen
        Razon stockRotation = new Razon();
        stockRotation.setIdestadof(v.getId());
        stockRotation.setnRazon("Rotacion de almacen");
        stockRotation.setValor(this.ToStockRotation(v.getntsls(), v.getInvt()));
        listRazonesRotacion.add(stockRotation);
        
        //Rotacion del capital circulante
        Razon capitalTurnover = new Razon();
        capitalTurnover.setIdestadof(v.getId());
        capitalTurnover.setnRazon("Rotacion del capital circulante");
        capitalTurnover.setValor(this.ToCapital(v.getntsls(), v.getWrkcp()));
        listRazonesRotacion.add(capitalTurnover);
        
        return listRazonesRotacion;
    }
    
    //Calculo de razones de liquidez
    @Override
    @Transactional
    public ArrayList listaRazonesLiquidez(Valores v) {
        ArrayList listRazonesLiquidez = new ArrayList();
        
        //Capital de trabajo
        Razon workingCapital = new Razon();
        workingCapital.setIdestadof(v.getId());
        workingCapital.setnRazon("Capital de trabajo");
        workingCapital.setValor(this.LrWorkingCapital(v.getca(), v.getcl()));
        listRazonesLiquidez.add(workingCapital);
        
        //Capital de trabajo neto sobre total de activos
        Razon netWorkingCapitalOverTA = new Razon();
        netWorkingCapitalOverTA.setIdestadof(v.getId());
        netWorkingCapitalOverTA.setnRazon("Capital de trabajo sobre Total de activos");
        netWorkingCapitalOverTA.setValor(this.LrNetWorkingOverTotalAssets(v.getca(), v.getcl(), v.getta()));
        listRazonesLiquidez.add(netWorkingCapitalOverTA);
        
        //Capital de trabajo neto sobre deudas a corto plazo
        Razon netWorkinCapitalOnShortTermDeb = new Razon();
        netWorkinCapitalOnShortTermDeb.setIdestadof(v.getId());
        netWorkinCapitalOnShortTermDeb.setnRazon("Capital de trabajo sobre deudas a corto plazo");
        netWorkinCapitalOnShortTermDeb.setValor(this.LrNetWorkingOnShort(v.getca(), v.getcl()));
        listRazonesLiquidez.add(netWorkinCapitalOnShortTermDeb);
        
        //Test ACIDO
        Razon acidTest = new Razon();
        acidTest.setIdestadof(v.getId());
        acidTest.setnRazon("Test Acido");
        acidTest.setValor(this.LrAcidTest(v.getca(), v.getInvt(), v.getcl()));
        listRazonesLiquidez.add(acidTest);
        
        //Dias de medicion del intervalo de tiempo
        Razon dayTimeInterval = new Razon();
        dayTimeInterval.setIdestadof(v.getId());
        dayTimeInterval.setnRazon("Medicion del intervalo de tiempo");
        dayTimeInterval.setValor(this.LrDaytimeIntervalMeasurement(v.getca(), v.getcm()));
        listRazonesLiquidez.add(dayTimeInterval);
        
        //Razon corriente
        Razon currentRatio = new Razon();
        currentRatio.setIdestadof(v.getId());
        currentRatio.setnRazon("Razon corriente");
        currentRatio.setValor(this.LrCurrentRatio(v.getca(), v.getcl()));
        listRazonesLiquidez.add(currentRatio);
        
        //Razon de efectivo
        Razon cashRatio = new Razon();
        cashRatio.setIdestadof(v.getId());
        cashRatio.setnRazon("Razon de efectivo");
        cashRatio.setValor(this.LrCashRatio(v.getef(), v.getcl()));
        listRazonesLiquidez.add(cashRatio);
        
        return listRazonesLiquidez;
    }
    //Calculo de razones de solvencia
    @Override
    @Transactional
    public ArrayList listaRazonesSolvencia(Valores v) {
        ArrayList listRazonesSolvencia = new ArrayList();

        //Coeficiente de endeudamiento
        Razon debtToEquity = new Razon();
        debtToEquity.setIdestadof(v.getIdEstado());
        debtToEquity.setnRazon("Coeficiente de endeudamiento");
        debtToEquity.setValor(this.SrDebtToEquity(v.getra(), v.getrp()));
        listRazonesSolvencia.add(debtToEquity);

        //Calidad de la deuda
        Razon debtQuality = new Razon();
        debtQuality.setIdestadof(v.getIdEstado());
        debtQuality.setnRazon("Calidad de la deuda");
        debtQuality.setValor(this.SrDebtQuality(v.getracp(), v.getra()));
        listRazonesSolvencia.add(debtQuality);

        //Razon de deuda
        Razon debtRatio = new Razon();
        debtRatio.setIdestadof(v.getIdEstado());
        debtRatio.setnRazon("Razon de deuda");
        debtRatio.setValor(this.SrDebtRatio(v.getTl(), v.getta()));
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
        return (totalLiabilities / totalAssets);
    }

}
