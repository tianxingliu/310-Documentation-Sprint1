Given(/^I visit the website and database is empty$/) do
  visit "localhost:9090"
end

When(/^I search for "([^"]*)" and expect 5 results$/) do |query|
    fill_in('search', :with => query)
    fill_in('number', :with => 3)
end

When(/^press "([^"]*)" button$/) do |buttonName|
  click_button(buttonName)
end

When(/^press a recipe$/) do
    find('#Rec_item0').click
end

When(/^press the third recipe$/) do
    find('#Rec_item2').click
end

When(/^press a restaurant$/) do
    find('#Res_item0').click
end

When(/^press an info item$/) do
    find('#item0').click
end

When(/^press the "([^"]*)"$/) do |elementName|
    find('#' + elementName).click
end
#
# When(/^I press "Add to grocery" button$/) do
#     page.find('.addToGrocery', match: :first).click
# end
#
# When(/^I press "Display Grocery" bnutton$/) do
#     page.find('#display_grocery', match: :first).click
# end

Then(/^I should see the "([^"]*)" page$/) do |pageTitle|
    expect(page).to have_title pageTitle
end

Then(/^I should see a title "([^"]*)"$/) do |query|
    expect(page).to have_content(query)
end

Then(/^I should see an element "([^"]*)"$/) do |elementName|
    expect(page).to have_css('#' + elementName)
end

Then(/^I should see  "([^"]*)" results$/) do |numResults|
    expect(page).to have_no_css('#Res_item' + numResults)
    expect(page).to have_no_css('#Rec_item' + numResults)
end

Then(/^I should see "([^"]*)" on the top of recipes$/) do |recipeName|
    expect(page).to have_css('div.Rec_section1')
end

Then(/^I should not see recipe "([^"]*)"$/) do |recipeName|
    expect(page).to have_no_content(recipeName)
end

Then(/^I should see the printable version page$/) do
    expect(page).to have_no_css('image')
end

When(/^select the list "([^"]*)"$/) do |listName|
    find('.select-selected').click
    all('div', :text => listName)[2].click
end

Then(/^I should see an info item$/) do
    expect(page).to have_css('#item0')
end

Then(/^I should see the page of To Explore List$/) do
    expect(page).to have_content('To Explore List')
end

Then(/^I should see the "Display Grocery" button$/) do
#    expect(page).to have_css('#display_grocery')
    page.find('#display_grocery')
end

Then(/^I should see the "Add to Grocery" button$/) do
#    expect(page).to have_css('#display_grocery')
    page.find('.addToGrocery')
end

Then(/^I will go to the Grocery Page$/) do
#    expect(page).to have_css('#display_grocery')
   expect(page).to have_title("Grocery")
end

Then(/^the item will be added to the grocery list$/) do
   expect(page).to have_content("soy sauce")
end

When(/^restart session$/) do
    Capybara.reset_sessions!
end
