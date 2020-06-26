<div class="center-children-form fieldcontain required ${hasErrors(bean: announcement, field: 'articleName', 'errors')}">
    <label class="" for="articleName">Article Name<span class='required-indicator'>*</span></label>
    <g:textField
            class="textfields"
            type="text"
            name="articleName"
            required=""
            id="articleName"
            value="${fieldValue(bean: announcement, field: 'articleName')}"/>

    <g:hasErrors bean="${announcement}" field="articleName">
        <div>
            <g:message error="${errorMessagess[0]}"/>
        </div>
    </g:hasErrors>
</div>

<div class="fieldcontain ${hasErrors(bean: announcement, field: 'articleDescription', 'errors')}">
    <label class="" for="articleDescription">Description</label>
    <g:textArea name="articleDescription"
                value="${fieldValue(bean: announcement, field: 'articleDescription')}"
                id="articleDescription"/>

    <g:hasErrors bean="${announcement}" field="articleDescription">
        <div>
            <g:message error="${errorMessagess[1]}"/>
        </div>
    </g:hasErrors>

</div>

<div class="fieldcontain required ${hasErrors(bean: announcement, field: 'quantity', 'errors')}">
    <label for="quantity">Quantity<span class='required-indicator'>*</span></label>
    <g:field
            class="textfields"
            min="1"
            max="100"
            type="number"
            name="quantity"
            value="${fieldValue(bean: announcement, field: 'quantity')}"
            required=""
            id="quantity"/>

    <g:hasErrors bean="${announcement}" field="quantity">
        <div>
            <g:message error="${errorMessagess[2]}"/>
        </div>
    </g:hasErrors>

</div>

<div class="fieldcontain ${hasErrors(bean: announcement, field: 'address', 'errors')}">
    <label for="address">Address</label>
    <g:textField
            class="textfields"
            type="text"
            name="address"
            value="${fieldValue(bean: announcement, field: 'address')}"
            id="address"/>

    <g:hasErrors bean="${announcement}" field="address">
        <div>
            <g:message error="${errorMessagess[3]}"/>
        </div>
    </g:hasErrors>
</div>

<div class="fieldcontain required ${hasErrors(bean: announcement, field: 'email', 'errors')}">
    <label for="articleName">E-mail<span class='required-indicator'>*</span></label>
    <g:textField
            class="textfields"
            type="email"
            name="email"
            value="${fieldValue(bean: announcement, field: 'email')}"
            required=""
            id="email"/>

    <g:hasErrors bean="${announcement}" field="email">
        <div>
            <g:message error="${errorMessagess[4]}"/>
        </div>
    </g:hasErrors>
</div>

<div class="fieldcontain ${hasErrors(bean: announcement, field: 'username', 'errors')}">
    <label for="username">Username</label>
    <g:textField
            class="textfields"
            type="text"
            name="username"
            value="${fieldValue(bean: announcement, field: 'username')}"
            id="username"/>

    <g:hasErrors bean="${announcement}" field="username">
        <div>
            <g:message error="${errorMessagess[5]}"/>
        </div>
    </g:hasErrors>
</div>

<div class="fieldcontain ${hasErrors(bean: announcement, field: 'phoneNumber', 'errors')}">
    <label for="phoneNumber">Phone Number</label>
    <g:textField
            class="textfields"
            type="tel"
            name="phoneNumber"
            value="${fieldValue(bean: announcement, field: 'phoneNumber')}"
            id="phoneNumber"/>


    <g:hasErrors bean="${announcement}" field="phoneNumber">
        <div>
            <g:message error="${errorMessagess[6]}"/>
        </div>
    </g:hasErrors>

</div>


<div class="fieldcontain required ${hasErrors(bean: announcement, field: 'finalizationDate', 'errors')}">
    <label for="finalizationDate">Finalization Date<span class='required-indicator'>*</span></label>
    <g:datePicker
            type="date"
            id="finalizationDate"
            name="finalizationDate"
            date="${fieldValue(bean: announcement, field: 'finalizationDate')}"
            value="${announcement.finalizationDate}"
            precision="day"
            relativeYears="[0..1]"/>

    <g:hasErrors bean="${announcement}" field="finalizationDate">
        <div>
            <g:message error="${errorMessagess[7]}"/>
        </div>
    </g:hasErrors>
</div>


