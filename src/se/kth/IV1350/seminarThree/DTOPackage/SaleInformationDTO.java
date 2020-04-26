package se.kth.IV1350.seminarThree.DTOPackage;

import se.kth.IV1350.seminarThree.model.SaleInformation;

public class SaleInformationDTO {
private SaleInformation saleInfo;


    public SaleInformationDTO(SaleInformation saleInfo) {
        this.saleInfo = saleInfo;
    }

    @Override
    public String toString() {

        return String.format(this.saleInfo);
    }
}
