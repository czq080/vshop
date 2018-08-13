var Api = function () {
    this.prefix = "/api/"
}
api = new Api();
var Module = function () {
    this.prefix = api.prefix + "sys/";
}
module = new Module();
var Uris = function () {
    var sysuser = module.prefix + "v1/user/";
    this.sysuser_list = sysuser + "list";
    this.sysuser_info = sysuser + "info";
    this.sysuser_info_query = sysuser + "info/";
    this.sysuser_password = sysuser + "password";
    this.sysuser_save = sysuser + "save";
    this.sysuser_update = sysuser + "update";
    this.sysuser_delete = sysuser + "delete";

    var sysmenu = module.prefix + "v1/menu/";
    this.sysmenu_list = sysmenu + "list";
    this.sysmenu_queryAll = sysmenu + "queryAll";
    this.sysmenu_select = sysmenu + "select";
    this.sysmenu_perms = sysmenu + "perms";
    this.sysmenu_info_query = sysmenu + "info/";
    this.sysmenu_save = sysmenu + "save";
    this.sysmenu_update = sysmenu + "update";
    this.sysmenu_delete = sysmenu + "delete";
    this.sysmenu_user = sysmenu + "user";

    var sysdept = module.prefix + "v1/dept/";
    this.sysdept_list = sysdept + "list";
    this.sysdept_select = sysdept + "select";
    this.sysdept_info = sysdept + "info";
    this.sysdept_info_query = sysdept + "info/";
    this.sysdept_save = sysdept + "save";
    this.sysdept_update = sysdept + "update";
    this.sysdept_delete = sysdept + "delete";

    var sysrole = module.prefix + "v1/role/";
    this.sysrole_list = sysrole + "list";
    this.sysrole_select = sysrole + "select";
    this.sysrole_info_query = sysrole + "info/";
    this.sysrole_save = sysrole + "save";
    this.sysrole_update = sysrole + "update";
    this.sysrole_delete = sysrole + "delete";

    var sysconfig = module.prefix + "v1/config/";
    this.sysconfig_list = sysconfig + "list";
    this.sysconfig_info_query = sysconfig + "info/";
    this.sysconfig_save = sysconfig + "save";
    this.sysconfig_update = sysconfig + "update";
    this.sysconfig_delete = sysconfig + "delete";

    var sysmacro = module.prefix + "v1/macro/";
    this.sysmacro_list = sysmacro + "list";
    this.sysmacro_info_query = sysmacro + "info/";
    this.sysmacro_save = sysmacro + "save";
    this.sysmacro_update = sysmacro + "update";
    this.sysmacro_delete = sysmacro + "delete";
    this.sysmacro_queryAll = sysmacro + "queryAll";
    this.sysmacro_queryMacrosByValue = sysmacro + "queryMacrosByValue";

    var sysregion = module.prefix + "v1/region/";
    this.sysregion_list = sysregion + "list";
    this.sysregion_info_query = sysregion + "info/";
    this.sysregion_save = sysregion + "save";
    this.sysregion_update = sysregion + "update";
    this.sysregion_delete = sysregion + "delete";
    this.sysregion_getAllCountry = sysregion + "getAllCountry";
    this.sysregion_getAllProvice = sysregion + "getAllProvice";
    this.sysregion_getAllCity = sysregion + "getAllCity";
    this.sysregion_getChildrenDistrict = sysregion + "getChildrenDistrict";
    this.sysregion_getAreaByType= sysregion + "getAreaByType";

    var sysschedule = module.prefix + "v1/schedule/";
    this.sysschedule_list = sysschedule + "list";
    this.sysschedule_ = sysschedule + "list";
    this.sysschedule_info_query = sysschedule + "info/";
    this.sysschedule_save = sysschedule + "save";
    this.sysschedule_update = sysschedule + "update";
    this.sysschedule_delete = sysschedule + "delete";
    this.sysschedule_run = sysschedule + "run";
    this.sysschedule_pause = sysschedule + "pause";
    this.sysschedule_resume = sysschedule + "resume";
}
uris = new Uris();

