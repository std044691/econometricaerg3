/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

import model.CountryDataset;

/**
 *
 * @author themhz
 */
public class QuandleDataset {
    private CountryDataset dataset;

    public QuandleDataset() {
    }

    public CountryDataset getDataset() {
        return dataset;
    }

    public void setDataset(CountryDataset dataset) {
        this.dataset = dataset;
    }
    
}
