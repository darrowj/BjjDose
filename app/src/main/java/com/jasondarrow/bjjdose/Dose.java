package com.jasondarrow.bjjdose;

/**
 * Created by darrowj on 12/30/17.
 */

public class Dose {

    String id;
    String uid;
    String title;
    String Category;
    String engagement;
    String posture;
    String offensivePosition;
    String submission;
    String guard;
    String sweep;
    String description;
    String published;
    String created;
    String updated;

    public Dose(String id, String uid, String title, String category, String engagement,
                String posture, String offensivePosition, String submission, String guard,
                String sweep, String description, String published, String created) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        Category = category;
        this.engagement = engagement;
        this.posture = posture;
        this.offensivePosition = offensivePosition;
        this.submission = submission;
        this.guard = guard;
        this.sweep = sweep;
        this.description = description;
        this.published = published;
        this.created = created;
    }

    public Dose() {
    }

    public Dose(String id, String uid, String title, String description, String published) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.description = description;
        this.published = published;

    }

    public Dose(String uid, String title, String description, String published) {
        this.uid = uid;
        this.title = title;
        this.description = description;
        this.published = published;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getEngagement() {
        return engagement;
    }

    public void setEngagement(String engagement) {
        this.engagement = engagement;
    }

    public String getPosture() {
        return posture;
    }

    public void setPosture(String posture) {
        this.posture = posture;
    }

    public String getOffensivePosition() {
        return offensivePosition;
    }

    public void setOffensivePosition(String offensivePosition) {
        this.offensivePosition = offensivePosition;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public String getSweep() {
        return sweep;
    }

    public void setSweep(String sweep) {
        this.sweep = sweep;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        StringBuilder outStr = new StringBuilder();
        outStr.append(title + " | ");
        if (description.length() <= 10) {
            outStr.append(description);
        } else
            outStr.append(description.substring(0,10));
        return outStr.toString();
        /**
        return "Note{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", Category='" + Category + '\'' +
                ", engagement='" + engagement + '\'' +
                ", posture='" + posture + '\'' +
                ", offensivePosition='" + offensivePosition + '\'' +
                ", submission='" + submission + '\'' +
                ", guard='" + guard + '\'' +
                ", sweep='" + sweep + '\'' +
                ", description='" + description + '\'' +
                ", published='" + published + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
         **/
    }
}
