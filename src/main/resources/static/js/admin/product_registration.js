const RegisterEventService = {
    getCategorySelectObj: () => document.querySelectorAll(".product-inputs")[0],
    getNameInputObj: () => document.querySelectorAll(".product-inputs")[1],
    getPriceInputObj: () => document.querySelectorAll(".product-inputs")[2],
    getRegistInfo: () => document.querySelector(".regist-info"),
    getRegistButtonObj: () => document.querySelector(".regist-button"),

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
            console.log(RegisterObj);
        }
    }
}

const RegisterObj = {
    category: null,
    name: null,
    price: null
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