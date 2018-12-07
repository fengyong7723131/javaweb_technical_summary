package com.product.po.menu.base;


import com.fengyong.base.beans.Po;

/**
 * BaseSysMenuPo base model object
 *
 * @author wzy
 *         Created by wzy on 12/4/2015.
 * @version 1.0
 * @since 1.0
 */
public class BaseSysMenuPo extends Po {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单编号
     */
    private String menuCode;

    /**
     * 菜单目录名称
     */
    private String menuName;

    /**
     * 菜单目录资源URL
     */
    private String menuResource;

    /**
     * 菜单目录级数
     */
    private Integer menuLevelNumber;

    /**
     * 菜单目录类型
     */
    private String menuType;

    /**
     * 父目录id
     */
    private Long parentId;

    /**
     * 菜单目录顺序号
     */
    private Integer menuOrder;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 启/停状态
     */
    private String flag;



    /**
     * Sets new 菜单ID.
     *
     * @param menuId New value of 菜单ID.
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * Gets 菜单ID.
     *
     * @return Value of 菜单ID.
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * Sets new 菜单编号.
     *
     * @param menuCode New value of 菜单编号.
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * Gets 菜单编号.
     *
     * @return Value of 菜单编号.
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * Sets new 菜单目录名称.
     *
     * @param menuName New value of 菜单目录名称.
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * Gets 菜单目录名称.
     *
     * @return Value of 菜单目录名称.
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Sets new 菜单目录资源URL.
     *
     * @param menuResource New value of 菜单目录资源URL.
     */
    public void setMenuResource(String menuResource) {
        this.menuResource = menuResource;
    }

    /**
     * Gets 菜单目录资源URL.
     *
     * @return Value of 菜单目录资源URL.
     */
    public String getMenuResource() {
        return menuResource;
    }

    /**
     * Sets new 菜单目录级数.
     *
     * @param menuLevelNumber New value of 菜单目录级数.
     */
    public void setMenuLevelNumber(Integer menuLevelNumber) {
        this.menuLevelNumber = menuLevelNumber;
    }

    /**
     * Gets 菜单目录级数.
     *
     * @return Value of 菜单目录级数.
     */
    public Integer getMenuLevelNumber() {
        return menuLevelNumber;
    }

    /**
     * Sets new 菜单目录类型.
     *
     * @param menuType New value of 菜单目录类型.
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * Gets 菜单目录类型.
     *
     * @return Value of 菜单目录类型.
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * Sets new 父目录id.
     *
     * @param parentId New value of 父目录id.
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets 父目录id.
     *
     * @return Value of 父目录id.
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * Sets new 菜单目录顺序号.
     *
     * @param menuOrder New value of 菜单目录顺序号.
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * Gets 菜单目录顺序号.
     *
     * @return Value of 菜单目录顺序号.
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * Sets new 是否删除.
     *
     * @param isDelete New value of 是否删除.
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * Gets 是否删除.
     *
     * @return Value of 是否删除.
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * Sets new 启/停状态.
     *
     * @param flag New value of 启/停状态.
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * Gets 启/停状态.
     *
     * @return Value of 启/停状态.
     */
    public String getFlag() {
        return flag;
    }
}