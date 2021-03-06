package no.uia.slit.web;


/**
 * Using an enum rather than strings to refer to pages (views in JSF lingo)
 * eliminates typos in page references.
 *
 * @author even
 */
public enum Page {
    home("/index"),
    teacher("/teacher/index"),
    modules("/admin/listModules"),
    module("createModule"),
    newStudent("/admin/createStudent"),
    admin("/admin/index"),
    users,
    user,
    student("/student/overview"),
    plan("/student/createPlan"),
    planItem("/student/createPlanItem"),
    planItems("/student/listPlanItems")
    ;

    String url;

    Page(String url) {
        this.url = url;
    }

    Page() {
        this.url = this.name();
    }

    public String toString() {
        return url;
    }

}
