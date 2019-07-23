# Custom Lint Rules
At this moment there are five custom lint rules:
1. Validate maximum count of method params
2. Validate boolean params of method params
3. Validate rule "One method for one level of abstraction"
4. Validate interface method without prefix
5. Validate interface implementation with suffix "Impl" 

Follow these steps to add rules to your module:
1. Download project
2. Import lint module to your project
3. Add `lintChecks project(":lint")` to you gradle file of module
4. Restart Android Studio.
