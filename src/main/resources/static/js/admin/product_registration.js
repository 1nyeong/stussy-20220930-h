const RegisterEventService = {
    getCategorySelectObj: () => document.querySelectorAll(".product-inputs")[0],
    getNameInputObj: () => document.querySelectorAll(".product-inputs")[1],
    getPriceInputObj: () => document.querySelectorAll(".product-inputs")[2],
    getRegistInfo: () => document.querySelector(".regist-info"),
    getRegistButtonObj: () => document.querySelector(".regist-button"),
    getInfoTextareaObjs: () => document.querySelectorAll(".product-inputs"),

    init: function() {
        this.getNameInputObj().disabled = true;
        this.getPriceInputObj().disabled = true;
        this.getRegistButtonObj().disabled = true;
    },

    addCategorySelectEvent: function() {
        this.getCategorySelectObj().onchange = () => {
            if(this.getCategorySelectObj().value != "none"){
                this.getNameInputObj().disabled = false;
            }else{
                this.getNameInputObj().disabled = true;
            }
            RegisterObj.category = this.getCategorySelectObj().value;
        }
    },

    addNameInputEvent: function() {
        this.getNameInputObj().onkeyup = () => {
            if(this.getNameInputObj().value.length != 0){
                this.getPriceInputObj().disabled = false;
            }else{
                this.getPriceInputObj().disabled = true;
            }
            RegisterObj.name = this.getNameInputObj().value;
        }
    },

    addPriceInputEvent: function() {
        this.getPriceInputObj().onkeyup = () => {
            if(this.getPriceInputObj().value.length != 0){
                this.getRegistButtonObj().disabled = false;
                this.getRegistInfo().classList.remove("regist-info-invisible");
            }else{
                this.getRegistButtonObj().disabled = true;
                this.getRegistInfo().classList.add("regist-info-invisible");
            }
            RegisterObj.price = this.getPriceInputObj().value;
        }
    },

    addRegistButtonEvent: function() {
        this.getRegistButtonObj().onclick = () => {
            RegisterObj.simpleInfo = this.getInfoTextareaObjs()[3].value;
            RegisterObj.detailInfo = this.getInfoTextareaObjs()[4].value;
            RegisterObj.optionInfo = this.getInfoTextareaObjs()[5].value;
            RegisterObj.managementInfo = this.getInfoTextareaObjs()[6].value;
            RegisterObj.shippingInfo = this.getInfoTextareaObjs()[7].value;
            
            console.log(RegisterObj);
            
            RegisterEventService.createProductRequest();
        }
    }
}

const RegisterRequestService = {
    createProductRequest: () => {
        let responseResult = null;

        $.ajax({
            async: false,
            type: "post",
            url: "api/admin/product",
            contentType: "application/json",
            data: JSON.stringify(RegisterObj),
            dataType: "json",
            success: (response) => {
                responseResult = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        })

        return responseResult;
    }
}

const RegisterObj = {
    category: null,
    name: null,
    price: null,
    simpleInfo: null,
    detailInfo: null,
    optionInfo: null,
    managementInfo: null,
    shippingInfo: null
}

const ProductRegistration = {
    initRegisterEvent: () => {
        RegisterEventService.init();
        RegisterEventService.addCategorySelectEvent();
        RegisterEventService.addNameInputEvent();
        RegisterEventService.addPriceInputEvent();
        RegisterEventService.addRegistButtonEvent();
    }
}

window.onload = () => {
    ProductRegistration.initRegisterEvent();
}